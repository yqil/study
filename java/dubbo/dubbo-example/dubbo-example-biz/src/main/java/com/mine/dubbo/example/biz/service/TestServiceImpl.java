package com.mine.dubbo.example.biz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mine.dubbo.example.common.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	private static Logger log = LoggerFactory.getLogger(TestServiceImpl.class);
	
	@Override
	public String test(String s) {
		log.info("传入参数：{}", s);
		return "测试方法返回值";
	}

}
