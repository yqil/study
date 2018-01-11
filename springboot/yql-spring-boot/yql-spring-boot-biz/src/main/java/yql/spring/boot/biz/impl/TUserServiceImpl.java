package yql.spring.boot.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import yql.spring.boot.biz.dao.auto.tuser.TUserMapper;
import yql.spring.boot.biz.dao.handler.tuser.TUserDao;
import yql.spring.boot.common.model.auto.tuser.TUser;
import yql.spring.boot.common.model.auto.tuser.TUserExample;
import yql.spring.boot.common.model.handler.tuser.TUserChildrenVO;
import yql.spring.boot.common.service.TUserService;
import yql.spring.boot.common.util.errcode.ErrConstant;
import yql.spring.boot.common.util.exception.BusinessException;
import yql.spring.boot.common.util.logback.LogBackUtil;
import yql.spring.boot.common.util.mybatis.Page;
import yql.spring.boot.common.util.result.OutputPageResult;

@Service
public class TUserServiceImpl implements TUserService {
	
	@Autowired
	private TUserMapper tUserMapper;
	
	@Autowired
	private TUserDao tUserDao;

	@Override
	public OutputPageResult queryTUserPage(TUserChildrenVO user) throws BusinessException {
		LogBackUtil.getLogger().info("OaDemoServiceImpl->queryOaDemoPage参数分别为：{}", JSON.toJSONString(user));
		if(user == null){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		LogBackUtil.getLogger().debug("组装查询条件");
		TUserExample userExample = new TUserExample();
		TUserExample.Criteria userCriteria = userExample.createCriteria();
		if(!StringUtils.isEmpty(user.getName())){
			userCriteria.andNameEqualTo(user.getName());
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
	public TUser getTUserById(String id) throws BusinessException {
		LogBackUtil.getLogger().info("OaDemoServiceImpl->queryOaDemoPage参数分别为：{}", id);
		if(StringUtils.isEmpty(id)){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		
		return tUserDao.getTUserById(id);
	}

}
