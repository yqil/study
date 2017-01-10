package com.mine.dubbo.example.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mine.dubbo.example.common.model.autocode.TUserAddress;
import com.mine.dubbo.example.common.service.AddrService;
import com.mine.dubbo.example.common.util.ErrorCode;
import com.mine.study.whole.util.exception.SysException;
import com.mine.study.whole.util.result.Result;

@Controller
@RequestMapping(value="/e", produces = "application/json;charset=UTF-8")
public class AddrController
{

    private static Logger log = LoggerFactory.getLogger(AddrController.class);
    
    @Autowired
    private AddrService addrService;
    
    @RequestMapping(value = "/saveAddr", method = RequestMethod.POST)
    @ResponseBody
    public Result saveAddr(@RequestBody TUserAddress addr) throws Exception{
        try{
            log.info("saveAddr传入参数:{}", JSON.toJSONString(addr));
            String addrId = addrService.saveAddr(addr);
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, addrId, true);
        }catch(SysException e){
            log.error("saveAddr出现异常：", e);
            return new Result(e.getCode(), e.getMessage(), null, false);
        }catch(Exception e){
            log.error("saveAddr出现异常：", e);
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
}
