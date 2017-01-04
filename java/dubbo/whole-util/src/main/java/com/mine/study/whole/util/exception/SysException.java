package com.mine.study.whole.util.exception;

public class SysException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = 339636248046945371L;
    /**
     * 错误编码
     */
    private Integer code;

    public SysException(String message) {
        super(message);
    }
    
    public SysException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public SysException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public SysException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public SysException(Throwable throwable) {
        super(throwable);
    }

    public int getCode()
    {
        return code;
    }

}
