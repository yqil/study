package com.mine.study.common.service;

import com.mine.study.common.model.autocode.TUserAccount;
import com.mine.study.whole.util.exception.SysException;

public interface AccountService
{

    public TUserAccount queryAccount(String userId, String type) throws SysException;
}
