package com.mine.study.whole.util.uuid;

import java.util.UUID;


/**
 * @Description uuid工具类
 * @author bm
 * @date 2016年11月13日 上午10:48:28
 */
public class UuidUtils
{
    /**
     * @Description 获取32位uuid
     * @author bm
     * @date 2016年11月13日 上午11:09:38
     * @return
     * @lastModifier
     */
    public static String get32Uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
