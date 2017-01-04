package com.mine.study.whole.util.collections;

import java.util.List;

/**
 * 
 * @Description list工具包
 * @author bm
 * @date 2016年11月13日 上午10:19:57
 */
public class ListUtils
{
    /**
     * @Description 判断集合是否为null或空
     * @author bm
     * @date 2016年11月13日 上午10:21:56
     * @param list 
     * @return
     * @lastModifier
     */
    public static <T> boolean isEmpty(List<T> list){
        return list == null || list.isEmpty();
    }
    /**
     * @Description 判断集合是否不为空
     * @author bm
     * @date 2016年11月13日 上午10:21:56
     * @param list 
     * @return
     * @lastModifier
     */
    public static <T> boolean isNotEmpty(List<T> list){
        return list != null && !list.isEmpty();
    }
}
