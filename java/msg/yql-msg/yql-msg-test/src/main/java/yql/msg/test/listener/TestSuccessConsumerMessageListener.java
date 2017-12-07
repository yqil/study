package yql.msg.test.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSON;

import yql.msg.common.model.manual.tmsg.TMsgCommon;
import yql.msg.common.service.TMsgService;
import yql.msg.common.util.logback.LogBackUtil;

public class TestSuccessConsumerMessageListener implements SessionAwareMessageListener<Message>{

	@Autowired
	private TMsgService tMsgService;
	
	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		//1、获取消息
		TextMessage tm = (TextMessage)message;
		String msgContent = tm.getText();
		LogBackUtil.getLogger().debug("获得的消息为：{}", msgContent);
		TMsgCommon tmc = JSON.parseObject(msgContent, TMsgCommon.class);
		//2、业务操作
		if(tmc.getMsgId().equals("c9bcb1892fc444ca9d2fcb43443436a8")){
			LogBackUtil.getLogger().debug("业务操作成功");
		}else{
			LogBackUtil.getLogger().debug("业务操作失败");
			throw new JMSException("业务操作失败");
		}
		//3、确认消息
		tMsgService.confirmMsg(tmc.getMsgId(), true);
	}

}
