package yql.spring.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yql.spring.boot.common.model.auto.tuser.TUser;
import yql.spring.boot.common.model.handler.tuser.TUserChildrenVO;
import yql.spring.boot.common.service.TUserService;
import yql.spring.boot.common.util.result.OutputPageResult;

@RestController
public class HelloController {
	
	@Autowired
	private TUserService tUserService;
	
	@GetMapping("/hello")
	public OutputPageResult helloWorld(){
		TUserChildrenVO user = new TUserChildrenVO();
		return tUserService.queryTUserPage(user);
	}
	
	@GetMapping("/hello1")
	public TUser helloWorld1(){
		return tUserService.getTUserById("111");
	}
}
