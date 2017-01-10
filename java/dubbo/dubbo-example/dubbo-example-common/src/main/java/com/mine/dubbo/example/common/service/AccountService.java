package com.mine.dubbo.example.common.service;

import java.util.List;

import com.mine.dubbo.example.common.model.autocode.TUserAccount;
import com.mine.dubbo.example.common.model.autocode.TUserAccountDetail;
import com.mine.dubbo.example.common.model.autocode.TUserAccountDetailExample;
import com.mine.study.whole.util.exception.SysException;

public interface AccountService
{

    public TUserAccount queryAccount(String userId, String type) throws SysException;
    
    public List<TUserAccountDetail> listAccountDetail(TUserAccountDetailExample example) throws SysException;
}
