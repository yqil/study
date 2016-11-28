package com.mine.study.common.util;

public class ErrorCode
{
    /**
     * 成功
     */
    public interface SUCCESS{
        Integer code = 0;
        
        String msg = "接口调用成功";
    }
    
    /**
     * 参数为空
     */
    public interface PARAMISNULL{
        Integer code = -1;
        
        String msg = "接口传入参数为空";
    }
    
    /**
     * 系统异常
     */
    public interface SYSEXCEPTION{
        Integer code = -2;
        
        String msg = "系统出现异常";
    }
}
