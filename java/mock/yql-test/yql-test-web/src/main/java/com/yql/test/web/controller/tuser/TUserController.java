package com.yql.test.web.controller.tuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yql.test.common.model.handler.tuser.TUserChildrenVO;
import com.yql.test.common.service.tuser.TUserService;
import com.yql.test.common.util.constant.CommonResultConstant;
import com.yql.test.common.util.exception.BusinessException;
import com.yql.test.common.util.logback.LogBackUtil;
import com.yql.test.common.util.result.OutputResult;

@RestController  
@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8")  
public class TUserController {

	@Autowired
	private TUserService tUserService;
	
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)  
    public OutputResult userId(@PathVariable("id") String id) {  
        OutputResult rs = new OutputResult();
		try {
			LogBackUtil.getLogger().info("/test/user/id的参数为：{}", id);
			
			TUserChildrenVO user = new TUserChildrenVO();
			user.setId(id);
			
			rs.setStatus(CommonResultConstant.SUCCESS.CODE);
			rs.setMsg(CommonResultConstant.SUCCESS.MSG);
			rs.setData(tUserService.queryTUserPage(user));
			return rs;
		} catch (BusinessException e) {
			LogBackUtil.getLogger().error("/test/user/id的参数为：{}", id, e);
			rs.setStatus(e.getCode());
			rs.setMsg(e.getMessage());
			return rs;
		} catch (Exception e) {
			LogBackUtil.getLogger().error("/test/user/id的参数为：{}", id, e);
			rs.setStatus(CommonResultConstant.SYS_EXCEPTION.CODE);
			rs.setMsg(CommonResultConstant.SYS_EXCEPTION.MSG);
			return rs;
		}
    } 
	
}
