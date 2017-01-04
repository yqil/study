package com.mine.dubbo.example.biz.service;

import org.springframework.stereotype.Service;

import com.mine.dubbo.example.common.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public String test(String s) {
		
		return "测试方法返回值";
	}

}
