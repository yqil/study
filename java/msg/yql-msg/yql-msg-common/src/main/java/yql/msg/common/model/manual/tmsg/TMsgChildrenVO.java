package yql.msg.common.model.manual.tmsg;

import java.util.List;

import yql.msg.common.model.auto.tmsg.TMsg;
import yql.msg.common.util.mybatis.Page;

public class TMsgChildrenVO extends TMsg {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 2106470700567010729L;
	/**
	 * 分页信息
	 */
	private Page page;
	/**
	 * 排序字段
	 */
	private String orderStr;
	/**
	 * 是否删除，用于删除表信息
	 */
	private boolean isDelete;
	/**
	 * 1:预发送消息，2：业务操作失败，3：业务操作成功
	 */
	private Integer type;
	/**
	 * 多个状态查询条件
	 */
	private List<Short> statusIn;
	/**
	 * 重试次数大于查询条件
	 */
	private Short resetNumGreaterThan;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Short> getStatusIn() {
		return statusIn;
	}

	public void setStatusIn(List<Short> statusIn) {
		this.statusIn = statusIn;
	}

	public Short getResetNumGreaterThan() {
		return resetNumGreaterThan;
	}

	public void setResetNumGreaterThan(Short resetNumGreaterThan) {
		this.resetNumGreaterThan = resetNumGreaterThan;
	}

}
