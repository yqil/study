package yql.spring.boot.common.util.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 4823402015809514877L;
	/**
	 * 错误码
	 */
	private int code;

    public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
	
	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public BusinessException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

	public BusinessException(Throwable throwable) {
		super(throwable);
	}

    public int getCode()
    {
        return code;
    }
}
