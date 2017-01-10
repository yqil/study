package com.mine.dubbo.example.common.model;

import java.io.Serializable;

import com.mine.dubbo.example.common.model.autocode.TUser;
import com.mine.dubbo.example.common.model.autocode.TUserAddress;

public class UserAndAddrVO implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -7926014042882135178L;

    /**
     * 用户信息
     */
    private TUser user;

    /**
     * 地址信息
     */
    private TUserAddress addr;

    public TUser getUser()
    {
        return user;
    }

    public void setUser(TUser user)
    {
        this.user = user;
    }

    public TUserAddress getAddr()
    {
        return addr;
    }

    public void setAddr(TUserAddress addr)
    {
        this.addr = addr;
    }

}
