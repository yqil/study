package yql.spring.boot.common.util.constant;

/**
 * 接口通用状态码
 * @author bm
 *
 */
public class CommonResultConstant {
	/**
	 * 接口处理成功
	 * @author bm
	 *
	 */
	public interface SUCCESS{
		Integer CODE = 0;
		String MSG = "成功";
	}
	/**
	 * 接口出现系统异常
	 * @author bm
	 *
	 */
	public interface SYS_EXCEPTION{
		Integer CODE = -1;
		String MSG = "系统出现异常";
	}
	/**
	 * 接口出现数据库异常
	 * @author bm
	 *
	 */
	public interface DB_EXCEPTION{
		Integer CODE = -2;
		String MSG = "数据库出现异常";
	}
	
	/**
	 * 接口出现数据库异常
	 * @author bm
	 *
	 */
	public interface OTHER_EXCEPTION{
		Integer CODE = -9999;
		String MSG = "其他异常";
	}
}
