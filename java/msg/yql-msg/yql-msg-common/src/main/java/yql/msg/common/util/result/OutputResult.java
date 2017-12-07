package yql.msg.common.util.result;

/**
 * 接口返回信息统一定义类
 * @author bm
 *
 */
public class OutputResult {
	/**
	 * 接口处理结果状态，0：成功，负数表示失败
	 */
	private Integer status;
	/**
	 * 接口处理结果信息
	 */
	private String msg;
	/**
	 * 接口返回数据
	 */
	private Object data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
