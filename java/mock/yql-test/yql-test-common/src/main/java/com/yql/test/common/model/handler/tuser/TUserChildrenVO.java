package com.yql.test.common.model.handler.tuser;

import java.util.List;

import com.yql.test.common.model.auto.tuser.TUser;
import com.yql.test.common.util.mybatis.Page;

public class TUserChildrenVO extends TUser {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 7908433534119998663L;

	/**
	 * 分页信息
	 */
	private Page page;
	/**
	 * 排序字段
	 */
	private String orderStr;
	/**
	 * 批量删除的id集合
	 */
	private List<String> ids;

	/**
	 * 是否删除，用于删除表信息
	 */
	private boolean isDelete;
	/**
	 * name字段模糊查询条件
	 */
	private String nameLike;

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

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getNameLike() {
		return nameLike;
	}

	public void setNameLike(String nameLike) {
		this.nameLike = nameLike;
	}

	
}
