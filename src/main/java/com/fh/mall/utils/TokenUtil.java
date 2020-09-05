package com.fh.mall.utils;

import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Description: Token生成规则
 *
 * @Author: HueFu
 * @Date: 2020-8-31 9:57
 */
public class TokenUtil {
    /**
     * 用于获得用户登录的Token值
     * @param src System.currentTimeMillis+user.id+NumUtils.getRandom(4)，当前时间的毫秒数+用户id+4位随机数
     * @return
     */
    public static String getToken(String src){
        //这里是token的具体生成规则
        if (StringUtils.isEmpty(src)) {
            return "传过来的生成数值为空";
        }
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(src.getBytes());
            String result = new BigInteger(1, md5.digest()).toString(16);
            if (result.length() == 31) {
                result = result+"-";
            }
            return result;
        } catch (Exception e){
            return null;
        }
    }
}
