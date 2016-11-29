package com.mine.study.common.model;

import java.io.Serializable;

public class BindUserVO implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -8775261992572081987L;

    private String appId;

    private String phone;

    private String pwd;

    private Integer type;

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

}
