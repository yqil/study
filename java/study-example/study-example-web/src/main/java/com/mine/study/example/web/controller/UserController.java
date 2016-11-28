package com.mine.study.example.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mine.study.common.model.UserAndAddrVO;
import com.mine.study.common.model.autocode.TUser;
import com.mine.study.common.service.UserService;
import com.mine.study.common.util.ErrorCode;
import com.mine.study.common.util.PropertiesUtil;
import com.mine.study.whole.util.exception.SysException;
import com.mine.study.whole.util.result.Result;

@Controller
@RequestMapping(value="/e", produces = "application/json;charset=UTF-8")
public class UserController
{

    private static Logger log = LoggerFactory.getLogger(UserController.class);
    
    /**
     * 读取配置文件中的内容，该配置在config.properties和pom.xml中
     */
    @Autowired
    private PropertiesUtil propertiesUtil; 
    
    @Autowired
    private UserService userService;
    
    public Result getUserByOpenid(String appId){
        try{
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, userService.queryThirdUser(appId), true);
        }catch(SysException e){
            return new Result(e.getCode(), e.getMessage(), null, false);
        }catch(Exception e){
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
    
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ResponseBody
    public List<TUser> listUser() throws Exception{
        log.info("获取配置文件中的内容:{}", propertiesUtil.getUrl());
        List<TUser> list = userService.listUser(null);
        
        return list;
    }
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public Integer saveUser(@RequestBody TUser user) throws Exception{
        log.info("saveUser传入参数:{}", JSON.toJSONString(user));
        
        return userService.saveUser(user);
    }
    
    @RequestMapping(value = "/saveUserAndAddr", method = RequestMethod.POST)
    @ResponseBody
    public Integer saveUserAndAddr(@RequestBody UserAndAddrVO userAndAddr){
        try{
            log.info("saveUserAndAddr传入参数:{}", JSON.toJSONString(userAndAddr));
            
            return userService.saveUserAndAddress(userAndAddr);
        }catch(Exception e){
            log.error("系统出现异常", e);
            return null;
        }
    }
    
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() throws Exception{
        log.info("测试");
        
        return "eeee";
    }
    
    @RequestMapping(value = "/index")
    public String index() throws Exception{
        
        return "fileUpload";
    }
}
