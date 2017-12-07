package com.yql.test.biz.impl.tuser;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yql.test.biz.dao.auto.tuser.TUserMapper;
import com.yql.test.common.model.auto.tuser.TUser;
import com.yql.test.common.model.auto.tuser.TUserExample;
import com.yql.test.common.model.handler.tuser.TUserChildrenVO;
import com.yql.test.common.service.tuser.TUserService;
import com.yql.test.common.util.constant.CommonResultConstant;
import com.yql.test.common.util.exception.BusinessException;
import com.yql.test.common.util.logback.LogBackUtil;
import com.yql.test.common.util.mybatis.Page;
import com.yql.test.common.util.result.OutputPageResult;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {

	@Autowired
	private TUserMapper tUserMapper;
	
	@Override
	public OutputPageResult queryTUserPage(TUserChildrenVO user) throws BusinessException {
		LogBackUtil.getLogger().info("TUserServiceImpl->queryTUserPage参数分别为：{}", JSON.toJSONString(user));
		if(user == null){
			throw new BusinessException(CommonResultConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		
		LogBackUtil.getLogger().debug("组装查询条件");
		TUserExample userExample = new TUserExample();
		TUserExample.Criteria userCriteria = userExample.createCriteria();
		if(StringUtils.isNotBlank(user.getId())){
			userCriteria.andIdEqualTo(user.getId());
		}
		if(StringUtils.isNotBlank(user.getName())){
			userCriteria.andNameEqualTo(user.getName());
		}
		if(StringUtils.isNotBlank(user.getNameLike())){
			userCriteria.andNameLike(user.getNameLike());
		}
		
		OutputPageResult rs = new OutputPageResult();
		Page page = user.getPage();
		if(page != null){
			LogBackUtil.getLogger().debug("获取记录总数");
			long count = tUserMapper.countByExample(userExample);
			rs.initPageInfo(count, page);
			LogBackUtil.getLogger().debug("设置分页信息");
			userExample.setPage(page);
		}
		
		LogBackUtil.getLogger().debug("设置查询的排序信息");
		userExample.setOrderByClause(user.getOrderStr());
		List<TUser> users = tUserMapper.selectByExample(userExample);
		
		rs.setList(users);
		return rs;
	}

	@Override
	public String saveTUser(TUserChildrenVO user) throws BusinessException {
		LogBackUtil.getLogger().info("OaDemoServiceImpl->saveOaDemo参数分别为：{}", JSON.toJSONString(user));
		if(user == null){
			throw new BusinessException(CommonResultConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		
		String userId = user.getId();
		if(user.isDelete()){
			LogBackUtil.getLogger().debug("删除表数据");
			tUserMapper.deleteByPrimaryKey(user.getId());
		}else if(StringUtils.isNotBlank(user.getId())){
			LogBackUtil.getLogger().debug("id存在，则调用更新sql");
			tUserMapper.updateByPrimaryKeySelective(user);
		}else {
			LogBackUtil.getLogger().debug("id不存在，则将信息写入数据库中");
			userId = UUID.randomUUID().toString().replace("-","");
			user.setId(userId);
			tUserMapper.insertSelective(user);
		}
		
		return userId;
	}
}
