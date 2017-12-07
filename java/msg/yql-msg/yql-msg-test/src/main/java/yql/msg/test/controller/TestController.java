package yql.msg.test.controller;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yql.msg.common.util.logback.LogBackUtil;

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
		TextMessage tm = (TextMessage)jmsTemplate.receive("test111");
		try {
			LogBackUtil.getLogger().debug(tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return "成功";
    } 
}
