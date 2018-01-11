package yql.spring.boot.common.service;

import yql.spring.boot.common.model.auto.tuser.TUser;
import yql.spring.boot.common.model.handler.tuser.TUserChildrenVO;
import yql.spring.boot.common.util.exception.BusinessException;
import yql.spring.boot.common.util.result.OutputPageResult;

/**
 * t_user表操作服务类
 * @author bm
 *
 */
public interface TUserService {
	/**
	 * 查询t_user表信息，并带有分页效果
	 * @param user 条件参数，如果page字段不为空，则带有分页效果，否则不带有分页效果
	 * @return
	 * @throws BusinessException
	 */
	public OutputPageResult queryTUserPage(TUserChildrenVO user) throws BusinessException;
	/**
	 * 测试手写sql
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public TUser getTUserById(String id) throws BusinessException;
}
