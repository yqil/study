package com.yql.test.common.service.tuser;

import com.yql.test.common.model.handler.tuser.TUserChildrenVO;
import com.yql.test.common.util.exception.BusinessException;
import com.yql.test.common.util.result.OutputPageResult;

/**
 * tb_user表操作服务接口类
 * @author bm
 *
 */
public interface TUserService {

	/**
	 * 查询tb_user表信息，并带有分页效果
	 * @param user 条件参数，如果page字段不为空，则带有分页效果，否则不带有分页效果
	 * @return
	 * @throws BusinessException
	 */
	public OutputPageResult queryTUserPage(TUserChildrenVO user) throws BusinessException;
	/**
	 * 保存表信息
	 * @param user
	 * @throws BusinessException
	 */
	public String saveTUser(TUserChildrenVO user) throws BusinessException;
}
