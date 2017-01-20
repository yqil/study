package com.mine.study.common.util;

public class UserConstant
{
    /**
     * @Description 第三方绑定类型
     * @author bm
     * @date 2016年11月28日 下午4:11:55
     */
    public interface THIRDTYPE {
        /**
         * 微信
         */
        Integer WECHAT = 1;
        /**
         * qq
         */
        Integer QQ = 2;
    }
    
    public interface ADDRTYPE {
        /**
         * 不默认
         */
        Integer IFNOTDEFAULT = 1;
        /**
         * 默认
         */
        Integer IFDEFAULT = 2;
    }
}
