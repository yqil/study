package yql.spring.boot.biz.dao.handler.tuser;

import org.apache.ibatis.annotations.Mapper;

import yql.spring.boot.common.model.auto.tuser.TUser;

@Mapper
public interface TUserDao {
	/**
	 * 测试手写sql
	 * @param id
	 * @return
	 */
	public TUser getTUserById(String id);
}
