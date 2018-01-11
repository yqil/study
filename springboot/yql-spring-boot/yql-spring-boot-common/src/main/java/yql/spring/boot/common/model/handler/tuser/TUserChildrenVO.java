package yql.spring.boot.common.model.handler.tuser;

import yql.spring.boot.common.model.auto.tuser.TUser;
import yql.spring.boot.common.util.mybatis.Page;

public class TUserChildrenVO extends TUser {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 4198198245980219758L;

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

}
