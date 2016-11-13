package com.mine.study.whole.util.safe;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @Description md5工具类
 * @author bm
 * @date 2016年11月13日 上午9:44:56
 */
public class Md5Util
{
    /**
     * @Description md5加密
     * @author bm
     * @date 2016年11月13日 上午9:54:46
     * @param input 需要加密的字符串
     * @param charset 如果为空，则编码为utf-8
     * @return
     * @lastModifier
     */
    public static String md5(String input, String charset)
    {
        return DigestUtils.md5Hex(getContentBytes(input, charset));
    }
    
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            charset = "utf-8";
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
}
