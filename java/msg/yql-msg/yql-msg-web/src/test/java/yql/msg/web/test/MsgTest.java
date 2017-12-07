package yql.msg.web.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import yql.msg.common.model.manual.tmsg.TMsgChildrenVO;
import yql.msg.common.model.manual.tmsg.TMsgConstant;
import yql.msg.common.service.TMsgService;
import yql.msg.common.util.logback.LogBackUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml" })
public class MsgTest {
	
	@Autowired
	private TMsgService tMsgService;
	
	/**
	 * 预发送消息测试
	 */
	@Test
	@Ignore
	public void dealMsgWaitSendTest(){
		TMsgChildrenVO msg = new TMsgChildrenVO();
		msg.setMsgName("test_success");
		msg.setType(TMsgConstant.WAIT_SEND_TYPE);
		msg.setMsgContent("{userName: \"张三\", userAge: 18, userAddress: \"天朝\"}");
		String msgId = tMsgService.dealMsg(msg);
		LogBackUtil.getLogger().debug("预发送消息的消息id为：{}", msgId);//1fbe8bc5d5e542029422fea0000f4cec
	}
	
	/**
	 * 生产者业务操作失败需要删除预发送消息
	 */
	@Test
	@Ignore
	public void dealMsgBizFailTest(){
		TMsgChildrenVO msg = new TMsgChildrenVO();
		msg.setId("1fbe8bc5d5e542029422fea0000f4cec");
		msg.setType(TMsgConstant.OPERATE_FAIL_TYPE);
		String msgId = tMsgService.dealMsg(msg);
		LogBackUtil.getLogger().debug("删除消息的消息id为：{}", msgId);
	}
	
	/**
	 * 生产者业务操作成功
	 */
	@Test
	@Ignore
	public void dealMsgBizSuccessTest(){
		TMsgChildrenVO msg = new TMsgChildrenVO();
		msg.setId("c9bcb1892fc444ca9d2fcb43443436a8");
		msg.setType(TMsgConstant.OPERATE_SUCCESS_TYPE);
		String msgId = tMsgService.dealMsg(msg);
		LogBackUtil.getLogger().debug("预发送消息的消息id为：{}", msgId);
	}
	
	@Test
	@Ignore
	public void confirmMsgTest(){
		String msgId = tMsgService.confirmMsg("a51b2b9f4ad04aadb95ba041313a748e", true);
		LogBackUtil.getLogger().debug("确认消息的消息id为：{}", msgId);
	}
}
