package yql.msg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8")  
public class TestController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/msg/{msg}", method = RequestMethod.GET)  
	@ResponseBody
    public String userId(@PathVariable("msg") String msg) {  
		/*String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列" +destination+ "发送了消息------------" + msg);*/
		jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend("test111",msg);
        /*final String testMsg = msg;
        jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage tm = session.createTextMessage(testMsg);
				return tm;
			}
		});*/
		return "成功";
    } 
}
