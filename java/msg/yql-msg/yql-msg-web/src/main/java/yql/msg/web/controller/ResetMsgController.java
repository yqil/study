package yql.msg.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;

import yql.msg.common.model.auto.tmsg.TMsg;
import yql.msg.common.model.manual.tmsg.TMsgChildrenVO;
import yql.msg.common.model.manual.tmsg.TMsgQueue;
import yql.msg.common.service.TMsgService;
import yql.msg.common.util.logback.LogBackUtil;
import yql.msg.common.util.result.OutputPageResult;

@Controller
public class ResetMsgController {
	
	@Autowired
	private ThreadPoolTaskExecutor threadPool;
	
	@Autowired
	private TMsgService tMsgService;

	/**
	 * 从数据库中取出需要重发的数据，仅仅在容器重启的时候初始化一次
	 */
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init(){
		LogBackUtil.getLogger().debug("容器启动的时候，将数据库需要重新发送的消息加载到队列中");
		List<Short> status = new ArrayList<Short>();
		status.add(Short.valueOf("4"));
		status.add(Short.valueOf("6"));
		TMsgChildrenVO msg = new TMsgChildrenVO();
		msg.setResetNumGreaterThan(Short.valueOf("0"));
		msg.setStatusIn(status);
		OutputPageResult result = tMsgService.queryTMsgPage(msg);
		List<TMsg> msgs = (List<TMsg>) result.getList();
		
		TMsgQueue.list.addAll(msgs);
		resetMsg();
	}
	
	/**
	 * 将队列中的消息进行重发
	 * 
	 * 业务描述：
	 * 1、确认消息是否满足重发条件
	 * 2、满足重发条件后才重发消息
	 */
	private void resetMsg(){
		while(true){
			synchronized(TMsgQueue.list) { 
				//判断是否为空采用isEmpty，不要使用size方法，size方法会导致性能降低
				if(!TMsgQueue.list.isEmpty()){
					threadPool.execute(new Runnable() {
						
						@Override
						public void run() {
							TMsg msg = TMsgQueue.list.poll();
							if(msg == null){
								return ;
							}
							tMsgService.resetSendMsg(msg);
						}
					});
				}
			}
		}
	}
}
