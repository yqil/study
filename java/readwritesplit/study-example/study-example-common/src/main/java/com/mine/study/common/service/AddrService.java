package com.mine.study.common.service;

import com.mine.study.common.model.autocode.TUserAddress;
import com.mine.study.whole.util.exception.SysException;

public interface AddrService
{
    String saveAddr(TUserAddress addr) throws SysException;
}
