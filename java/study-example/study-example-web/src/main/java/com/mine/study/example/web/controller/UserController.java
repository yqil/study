package com.mine.study.example.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mine.study.common.model.BindUserVO;
import com.mine.study.common.model.autocode.TUser;
import com.mine.study.common.model.autocode.TUserExample;
import com.mine.study.common.service.UserService;
import com.mine.study.common.util.ErrorCode;
import com.mine.study.common.util.PropertiesUtil;
import com.mine.study.whole.util.exception.SysException;
import com.mine.study.whole.util.result.Result;

@Controller
@RequestMapping(value="/e", produces = "application/json;charset=UTF-8")
public class UserController
{

    private static Logger log = LoggerFactory.getLogger(UserController.class);
    
    /**
     * 读取配置文件中的内容，该配置在config.properties和pom.xml中
     */
    @Autowired
    private PropertiesUtil propertiesUtil; 
    
    @Autowired
    private UserService userService;
    
    /**
     * @Description 根据openid获取用户id
     * @author bm
     * @date 2016年11月28日 下午2:52:29
     * @param appId
     * @return
     * @lastModifier
     */
    @RequestMapping(value = "/getUserIdByOpenid", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserIdByOpenid(String appId){
        try{
            log.info("getUserIdByOpenid传入参数:{}", appId);
            
            if(StringUtils.isBlank(appId)){
                return new Result(ErrorCode.PARAMISNULL.code, ErrorCode.PARAMISNULL.msg, null, false);
            }
            
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, userService.queryThirdUserId(appId), true);
        }catch(SysException e){
            return new Result(e.getCode(), e.getMessage(), null, false);
        }catch(Exception e){
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
    
    @RequestMapping(value = "/bindUser", method = RequestMethod.POST)
    @ResponseBody
    public Result bindUser(@RequestBody BindUserVO user){
        try{
            log.info("bindUser传入参数:{}", JSON.toJSONString(user));
            
            if(user == null || StringUtils.isBlank(user.getAppId())){
                return new Result(ErrorCode.PARAMISNULL.code, ErrorCode.PARAMISNULL.msg, null, false);
            }
            
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, userService.thirdBind(user), true);
        }catch(SysException e){
            return new Result(e.getCode(), e.getMessage(), null, false);
        }catch(Exception e){
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
    
    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
    @ResponseBody
    public Result queryUser(@RequestBody TUser user){
        try{
            log.info("bindUser传入参数:{}", JSON.toJSONString(user));
            if(user == null){
                return new Result(ErrorCode.PARAMISNULL.code, ErrorCode.PARAMISNULL.msg, null, false);
            }
            
            TUserExample example = new TUserExample();
            example.createCriteria().andUserIdEqualTo(user.getUserId());
            TUser rs = userService.getUser(example);
            
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, rs, true);
        }catch(Exception e){
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
    
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ResponseBody
    public List<TUser> listUser() throws Exception{
        log.info("获取配置文件中的内容:{}", propertiesUtil.getUrl());
        List<TUser> list = userService.listUser(null);
        
        return list;
    }
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody TUser user) throws Exception{
        log.info("saveUser传入参数:{}", JSON.toJSONString(user));
        
        return userService.saveUser(user);
    }
    
}
