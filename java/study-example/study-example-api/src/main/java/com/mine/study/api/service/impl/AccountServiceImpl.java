package com.mine.study.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.study.api.dao.autocode.TUserAccountDetailMapper;
import com.mine.study.api.dao.autocode.TUserAccountMapper;
import com.mine.study.common.model.autocode.TUserAccount;
import com.mine.study.common.model.autocode.TUserAccountDetail;
import com.mine.study.common.model.autocode.TUserAccountDetailExample;
import com.mine.study.common.model.autocode.TUserAccountExample;
import com.mine.study.common.service.AccountService;
import com.mine.study.whole.util.collections.ListUtils;
import com.mine.study.whole.util.exception.SysException;

@Service("accountService")
public class AccountServiceImpl implements AccountService
{
    private static Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    
    @Autowired
    private TUserAccountMapper userAccountMapper;
    
    @Autowired
    private TUserAccountDetailMapper userAccountDetailMapper;

    @Override
    public TUserAccount queryAccount(String userId, String type) throws SysException
    {
        log.info("queryAccount传入参数:{}", userId);
        TUserAccountExample example = new TUserAccountExample();
        example.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(type);
        List<TUserAccount> rs = userAccountMapper.selectByExample(example);
        if(ListUtils.isEmpty(rs)){
            return null;
        }else {
            return rs.get(0);
        }
    }

    @Override
    public List<TUserAccountDetail> listAccountDetail(TUserAccountDetailExample example) throws SysException
    {
        return userAccountDetailMapper.selectByExample(example);
    }

}
