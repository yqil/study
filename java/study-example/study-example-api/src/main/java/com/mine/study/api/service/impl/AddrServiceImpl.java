package com.mine.study.api.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.mine.study.api.dao.autocode.TUserAddressMapper;
import com.mine.study.common.model.autocode.TUserAddress;
import com.mine.study.common.model.autocode.TUserAddressExample;
import com.mine.study.common.service.AddrService;
import com.mine.study.common.util.ErrorCode;
import com.mine.study.common.util.UserConstant;
import com.mine.study.whole.util.exception.SysException;
import com.mine.study.whole.util.uuid.UuidUtils;

@Service("addrService")
public class AddrServiceImpl implements AddrService
{
    
    private static Logger log = LoggerFactory.getLogger(AddrServiceImpl.class);
    
    @Autowired
    private TUserAddressMapper addressMapper;

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public String saveAddr(TUserAddress addr) throws SysException
    {
        if(StringUtils.isBlank(addr.getUserId())){
            throw new SysException(ErrorCode.PARAMISNULL.code, "用户id为空");
        }
        
        log.info("如果是保存默认地址，首先将该用户所有地址重置为不默认。方法入参：{}", JSON.toJSONString(addr));
        if(addr.getIfDefault() == UserConstant.ADDRTYPE.IFDEFAULT){
            TUserAddress updateAddr = new TUserAddress();
            updateAddr.setIfDefault(UserConstant.ADDRTYPE.IFNOTDEFAULT);
            TUserAddressExample example = new TUserAddressExample();
            example.createCriteria().andUserIdEqualTo(addr.getUserId());
            addressMapper.updateByExampleSelective(updateAddr, null);
        }
        
        log.info("保存地址信息");
        String addrId = addr.getAddrId();
        if(StringUtils.isBlank(addrId)){
            addrId = UuidUtils.get32Uuid();
            addr.setAddrId(addrId);
            addressMapper.insert(addr);
        }else {
            addressMapper.updateByPrimaryKeySelective(addr);
        }
        return addrId;
    }

}
