package com.mine.study.api.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.mine.study.api.dao.autocode.TUserMapper;
import com.mine.study.api.dao.autocode.TUserThirdMapper;
import com.mine.study.common.model.BindUserVO;
import com.mine.study.common.model.autocode.TUser;
import com.mine.study.common.model.autocode.TUserExample;
import com.mine.study.common.model.autocode.TUserThird;
import com.mine.study.common.model.autocode.TUserThirdExample;
import com.mine.study.common.service.UserService;
import com.mine.study.common.util.ErrorCode;
import com.mine.study.common.util.PropertiesUtil;
import com.mine.study.whole.util.collections.ListUtils;
import com.mine.study.whole.util.exception.SysException;
import com.mine.study.whole.util.safe.Md5Util;
import com.mine.study.whole.util.uuid.UuidUtils;

@Service("userService")
public class UserServiceImpl implements UserService
{
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private TUserMapper userMapper;
    
    @Autowired
    private TUserThirdMapper userThirdMapper;
    
    @Autowired
    private PropertiesUtil propertiesUtil;

    @Override
    public List<TUser> queryListUser(TUserExample example)
    {
        log.info("传入参数:{}", JSON.toJSONString(example));
        
        log.info("service中获取配置文件中的内容:{}", propertiesUtil.getUrl());
        return userMapper.selectByExample(example);
    }

    @Override
    public String saveUser(TUser user)
    {
        log.info("传入参数:{}", JSON.toJSONString(user));
        
        String userId = user.getUserId();
        if(StringUtils.isEmpty(userId)){
            userId = UuidUtils.get32Uuid();
            user.setUserId(userId);
            userMapper.insert(user);
        }else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        return userId;
    }

    @Override
    public TUser getUser(TUserExample example)
    {
        log.info("传入参数:{}", JSON.toJSONString(example));
        
        List<TUser> list = userMapper.selectByExample(example);
        if(ListUtils.isEmpty(list)){
            return null;
        }
        list.get(0).setUserPwd(null);
        return list.get(0);
    }

    @Override
    public boolean isExistsUser(TUserExample example)
    {
        log.info("传入参数:{}", JSON.toJSONString(example));
        
        return ListUtils.isEmpty(userMapper.selectByExample(example));
    }

    @Override
    public String queryThirdUserId(String appId) throws SysException
    {
        log.info("传入参数:{}", appId);
        
        if(StringUtils.isBlank(appId)){
            throw new SysException(ErrorCode.PARAMISNULL.code, "第三方应用id为空");
        }
        
        TUserThirdExample example = new TUserThirdExample();
        example.createCriteria().andAppIdEqualTo(appId);
        List<TUserThird> list = userThirdMapper.selectByExample(example);
        if(ListUtils.isEmpty(list)){
            return null;
        }
        return list.get(0).getUserId();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public String thirdBind(BindUserVO user) throws SysException
    {
        log.info("传入参数:{}", JSON.toJSONString(user));
        
        TUserThirdExample example = new TUserThirdExample();
        example.createCriteria().andAppIdEqualTo(user.getAppId());
        List<TUserThird> list = userThirdMapper.selectByExample(example);
        if(ListUtils.isNotEmpty(list)){
            throw new SysException(ErrorCode.USERALREADYBIND.code, ErrorCode.USERALREADYBIND.msg);
        }
        
        TUserExample userExample = new TUserExample();
        userExample.createCriteria().andPhoneEqualTo(user.getPhone());
        List<TUser> users = userMapper.selectByExample(userExample);
        String userId = null;
        if(ListUtils.isEmpty(users)){
            userId = UuidUtils.get32Uuid();
            TUser u = new TUser();
            u.setUserId(userId);
            u.setPhone(user.getPhone());
            u.setUserPwd(Md5Util.md5(user.getPwd(), null));
            u.setCreateTime(new Date());
            userMapper.insert(u);
        }
        
        TUserThird userThird = new TUserThird();
        userThird.setUserId(userId);
        userThird.setAppId(user.getAppId());
        userThird.setType((byte) user.getType().intValue());
        userThird.setId(UuidUtils.get32Uuid());
        userThirdMapper.insert(userThird);
        return userId;
    }

    
}
