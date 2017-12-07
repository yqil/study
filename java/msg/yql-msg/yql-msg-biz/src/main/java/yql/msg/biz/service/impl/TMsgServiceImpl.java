package yql.msg.biz.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import yql.msg.biz.dao.auto.tmsg.TMsgMapper;
import yql.msg.common.model.auto.tmsg.TMsg;
import yql.msg.common.model.auto.tmsg.TMsgExample;
import yql.msg.common.model.manual.tmsg.TMsgChildrenVO;
import yql.msg.common.model.manual.tmsg.TMsgCommon;
import yql.msg.common.model.manual.tmsg.TMsgConstant;
import yql.msg.common.model.manual.tmsg.TMsgQueue;
import yql.msg.common.service.TMsgService;
import yql.msg.common.util.errcode.ErrConstant;
import yql.msg.common.util.exception.BusinessException;
import yql.msg.common.util.logback.LogBackUtil;
import yql.msg.common.util.mybatis.Page;
import yql.msg.common.util.result.OutputPageResult;

@Service
public class TMsgServiceImpl implements TMsgService {

	@Autowired
	private TMsgMapper tMsgMapper;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public OutputPageResult queryTMsgPage(TMsgChildrenVO msg) throws BusinessException {
		LogBackUtil.getLogger().info("TMsgServiceImpl->queryTMsgPage参数为：{}", JSON.toJSONString(msg));
		if(msg == null){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		
		LogBackUtil.getLogger().debug("组装查询条件");
		TMsgExample msgExample = new TMsgExample();
		TMsgExample.Criteria msgCriteria = msgExample.createCriteria();
		if(StringUtils.isNotBlank(msg.getId())){
			msgCriteria.andIdEqualTo(msg.getId());
		}
		if(msg.getStatusIn() != null && !msg.getStatusIn().isEmpty()){
			msgCriteria.andStatusIn(msg.getStatusIn());
		}
		if(msg.getResetNumGreaterThan() != null){
			msgCriteria.andResetNumGreaterThan(msg.getResetNumGreaterThan());
		}
		
		OutputPageResult rs = new OutputPageResult();
		LogBackUtil.getLogger().debug("设置分页信息");
		Page page = msg.getPage();
		if(page != null){
			LogBackUtil.getLogger().debug("获取记录总数");
			long count = tMsgMapper.countByExample(msgExample);
			rs.initPageInfo(count, page);
			LogBackUtil.getLogger().debug("设置分页信息");
			msgExample.setPage(page);
		}
		
		LogBackUtil.getLogger().debug("设置查询的排序信息");
		msgExample.setOrderByClause(msg.getOrderStr());
		List<TMsg> msgs = tMsgMapper.selectByExampleWithBLOBs(msgExample);
		
		rs.setList(msgs);
		return rs;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String dealMsg(TMsgChildrenVO msg) throws BusinessException {
		LogBackUtil.getLogger().info("TMsgServiceImpl->dealMsg参数分别为：{}", JSON.toJSONString(msg));
		if(msg == null){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		if(msg.getType() == null){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "业务操作类型不能为空");
		}
		
		String msgId = msg.getId();
		if(msg.getType() == TMsgConstant.WAIT_SEND_TYPE){
			LogBackUtil.getLogger().debug("预发送消息，消息中间件直接存储消息到消息表中");
			if(StringUtils.isBlank(msg.getMsgName())){
				throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "预发送消息的消息名称不能为空");
			}
			if(StringUtils.isBlank(msg.getMsgContent())){
				throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "预发送消息的消息内容不能为空");
			}
			
			if(msg.getSendNum() == null || msg.getSendNum() == 0){
				msg.setSendNum(TMsgConstant.SEND_NUM);
				msg.setResetNum(TMsgConstant.RESET_NUM);
			}else{
				Integer resetNum = msg.getSendNum() > 1 ? msg.getSendNum() - 1 : 0;
				msg.setResetNum(resetNum.shortValue());
			}
			msgId = UUID.randomUUID().toString().replace("-","");
			Date date = new Date();
			msg.setId(msgId);
			msg.setCreateTime(date);
			msg.setLastSendTime(date);
			msg.setStatus(TMsgConstant.WAIT_CONFIRM);
			
			tMsgMapper.insertSelective(msg);
		}else if(msg.getType() == TMsgConstant.OPERATE_FAIL_TYPE){
			LogBackUtil.getLogger().debug("生产者业务操作失败，删除消息表中对应的消息");
			if(StringUtils.isBlank(msg.getId())){
				throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "消息id不能为空");
			}
			
			int delNum = tMsgMapper.deleteByPrimaryKey(msg.getId());
			if(delNum == 0){
				throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "消息id错误");
			}
		}else if(msg.getType() == TMsgConstant.OPERATE_SUCCESS_TYPE){
			LogBackUtil.getLogger().debug("生产者业务操作成功，将消息表中的消息状态设置为待发送");
			if(StringUtils.isBlank(msg.getId())){
				throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "消息id不能为空");
			}
			
			TMsg dbMsg = tMsgMapper.selectByPrimaryKey(msg.getId());
			if(dbMsg == null || dbMsg.getStatus() == null || dbMsg.getStatus() != 1){
				throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "消息id错误");
			}
			
			TMsgExample tMsgExample = new TMsgExample();
			tMsgExample.createCriteria().andIdEqualTo(msg.getId()).andStatusEqualTo(TMsgConstant.WAIT_CONFIRM);
			TMsg record = new TMsg();
			record.setStatus(TMsgConstant.WAIT_SEND);
			tMsgMapper.updateByExampleSelective(record, tMsgExample);
			
			LogBackUtil.getLogger().debug("调用mq接口，如果mq发送成功，则将消息表状态更新为已发送，否则更新为发送失败");
			this.resetSendMsg(dbMsg);
		}
		return msgId;
	}

	@Override
	public String confirmMsg(String msgId, boolean isSuccess) throws BusinessException {
		LogBackUtil.getLogger().info("TMsgServiceImpl->confirmMsg参数分别为：{}", msgId);
		if(StringUtils.isBlank(msgId)){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "参数不能为空");
		}
		
		TMsg record = new TMsg();
		record.setId(msgId);
		if(isSuccess){
			record.setStatus(TMsgConstant.DEAL_SUCCESS);
		}else {
			record.setStatus(TMsgConstant.DEAL_FAIL);
		}
		int num = tMsgMapper.updateByPrimaryKey(record);
		
		if(num == 0){
			throw new BusinessException(ErrConstant.OTHER_EXCEPTION.CODE, "消息id错误！");
		}
		return msgId;
	}

	@Override
	public void resetSendMsg(TMsg msg) throws BusinessException {
		try{
			TMsgCommon tmc = new TMsgCommon();
			tmc.setMsgId(msg.getId());
			tmc.setMsgContent(msg.getMsgContent());
			jmsTemplate.setPubSubDomain(false);
			/*if(msg.getResetRate() != null){
				LogBackUtil.getLogger().debug("延迟{}分钟发送", msg.getResetRate());
				jmsTemplate.setDeliveryDelay(msg.getResetRate() * 60 * 1000);
			}*/
			jmsTemplate.convertAndSend(msg.getMsgName(), JSON.toJSONString(tmc));
			
			TMsg record = new TMsg();
			record.setId(msg.getId());
			record.setStatus(TMsgConstant.SEND_SUCCESS);
			record.setResetNum(Short.valueOf(msg.getResetNum().intValue() - 1 + ""));
			record.setLastSendTime(new Date());
			tMsgMapper.updateByPrimaryKeySelective(record);
		}catch(JmsException e){
			LogBackUtil.getLogger().error("发送消息出现异常：{},{}",JSON.toJSONString(msg), e);
			TMsg record = new TMsg();
			record.setId(msg.getId());
			record.setStatus(TMsgConstant.SEND_FAIL);
			record.setResetNum(Short.valueOf(msg.getResetNum().intValue() - 1 + ""));
			tMsgMapper.updateByPrimaryKeySelective(record);
			LogBackUtil.getLogger().debug("发送出现异常的消息将消息放入队列中准备重新发送");
			TMsgQueue.list.add(msg);
		}
	}

}
