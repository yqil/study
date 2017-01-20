package com.mine.study.example.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mine.study.common.model.autocode.TUserAccountDetailExample;
import com.mine.study.common.service.AccountService;
import com.mine.study.common.util.ErrorCode;
import com.mine.study.whole.util.exception.SysException;
import com.mine.study.whole.util.mybatis.Page;
import com.mine.study.whole.util.result.Result;

@Controller
@RequestMapping(value="/e", produces = "application/json;charset=UTF-8")
public class AccountController
{

    private static Logger log = LoggerFactory.getLogger(AccountController.class);
    
    @Autowired
    private AccountService accountService;
    
    /**
     * @Description 获取账户信息
     * @author bm
     * @date 2016年11月28日 下午2:52:29
     * @param appId
     * @return
     * @lastModifier
     */
    @RequestMapping(value = "/queryAccount", method = RequestMethod.GET)
    @ResponseBody
    public Result queryAccount(@RequestParam(value="userId", required=true) String userId, @RequestParam(value="type", required=true) String type){
        try{
            log.info("queryAccount传入参数，用户id:{}，账户类型:{}", userId, type);
            
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, accountService.queryAccount(userId, type), true);
        }catch(SysException e){
            log.error("queryAccount出现异常：", e);
            return new Result(e.getCode(), e.getMessage(), null, false);
        }catch(Exception e){
            log.error("queryAccount出现异常：", e);
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
    
    @RequestMapping(value = "/listAccountDetail", method = RequestMethod.GET)
    @ResponseBody
    public Result listAccountDetail(@RequestParam(value="accountId", required=true) String accountId,
            @RequestParam(value="type", required=true) Integer page,
            @RequestParam(value="type", required=true) Integer pageSize){
        try{
            log.info("listAccount传入参数，账户id:{}，页码:{}", accountId, page);
            Page p = new Page();
            p.setBegin(page*pageSize);
            p.setLength(pageSize);
            TUserAccountDetailExample example = new TUserAccountDetailExample();
            example.createCriteria().andAccountIdEqualTo(accountId);
            example.setPage(p);
            example.setOrderByClause("create_time desc");
            
            return new Result(ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg, accountService.listAccountDetail(example), true);
        }catch(SysException e){
            log.error("queryAccount出现异常：", e);
            return new Result(e.getCode(), e.getMessage(), null, false);
        }catch(Exception e){
            log.error("queryAccount出现异常：", e);
            return new Result(ErrorCode.SYSEXCEPTION.code, ErrorCode.SYSEXCEPTION.msg, null, false);
        }
    }
    
}
