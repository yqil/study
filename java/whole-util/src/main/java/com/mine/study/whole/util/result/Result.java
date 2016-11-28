package com.mine.study.whole.util.result;

import java.io.Serializable;

public class Result implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -8025596336333558480L;

    /**
     * 接口返回状态码
     */
    private Integer code;

    /**
     * 接口返回消息
     */
    private String msg;

    /**
     * 接口返回内容
     */
    private Object content;

    /**
     * 接口是否成功，true：成功，false：不成功
     */
    private boolean status;

    public Result(Integer code, String msg, Object content, boolean status)
    {
        super();
        this.code = code;
        this.msg = msg;
        this.content = content;
        this.status = status;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getContent()
    {
        return content;
    }

    public void setContent(Object content)
    {
        this.content = content;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

}
