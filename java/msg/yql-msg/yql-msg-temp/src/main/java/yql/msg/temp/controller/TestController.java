package yql.msg.temp.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yql.msg.common.util.logback.LogBackUtil;

@RestController
@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8")
public class TestController {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/msg/{msg}", method = RequestMethod.GET)
	@ResponseBody
	public String test(@PathVariable("msg") String msg, HttpServletRequest request) {
		LogBackUtil.getLogger().debug("开始:{}", JSON.toJSONString(new Date()));
		String sessionId = request.getSession().getId();
		Map<String, Boolean> map = redisTemplate.opsForHash().entries(sessionId);
		LogBackUtil.getLogger().debug("msg->sessionid：{}", sessionId);
		LogBackUtil.getLogger().debug("缓存：{}", map.get(sessionId));
		boolean sessionValue = map.get(sessionId) == null ? false : map.get(sessionId);
		try {
			Thread.sleep(1000 * 60 * 3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (sessionValue) {
			LogBackUtil.getLogger().debug("结束:{}", JSON.toJSONString(new Date()));
			return "success";
		} else {
			LogBackUtil.getLogger().debug("结束:{}", JSON.toJSONString(new Date()));
			return "failed";
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/msgl/{msg}", method = RequestMethod.GET)
	@ResponseBody
	public String test(@PathVariable("msg") String msg, HttpServletRequest request, HttpServletResponse response) {
		String sessionId = request.getSession().getId();
		Map<String, Boolean> map = redisTemplate.opsForHash().entries(sessionId);
		LogBackUtil.getLogger().debug("msgl->sessionid：{}", sessionId);
		boolean sessionValue = map.get(sessionId) == null ? false : map.get(sessionId);
		if(!sessionValue){
			BoundHashOperations boundHashOperations = redisTemplate.boundHashOps(sessionId);
			boundHashOperations.put(sessionId, true);
		}
		return msg;
	}
}
