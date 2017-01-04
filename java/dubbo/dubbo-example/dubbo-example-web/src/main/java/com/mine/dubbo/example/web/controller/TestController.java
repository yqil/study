package com.mine.dubbo.example.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mine.dubbo.example.common.service.TestService;

@Controller
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
    @ResponseBody
    public String test(String params){
		log.info("传入参数：{}", params);
		return testService.test(params);
	}
}
