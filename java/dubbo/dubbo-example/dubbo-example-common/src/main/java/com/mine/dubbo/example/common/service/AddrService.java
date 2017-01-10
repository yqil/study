package com.mine.dubbo.example.common.service;

import com.mine.dubbo.example.common.model.autocode.TUserAddress;
import com.mine.study.whole.util.exception.SysException;

public interface AddrService
{
    String saveAddr(TUserAddress addr) throws SysException;
}
