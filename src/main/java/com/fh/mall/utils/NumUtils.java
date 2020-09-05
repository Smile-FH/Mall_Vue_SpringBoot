package com.fh.mall.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: 数字验证工具包
 *
 * @Author: HueFu
 * @Date: 2020-8-31 9:48
 */
public class NumUtils {

    /**
     * 获得固定长度的随机数字
     *
     * @param length
     * @return
     */
    public static int getRandom(int length){
        int n = 1;
        double random = Math.random();
        if (random<0.1) {
            random = random+0.1;
        }
        for (int i = 0; i < length; i++) {
            n = n * 10;
        }
        return (int)(random*n);
    }

    public static boolean isPhone(String phone){
        Pattern pattern = Pattern.compile("^((\\+|00)86)?((134\\d{4})|((13[0-3|5-9]|14[1|5-9]|15[0-9]|16[2|5|6|7]|17[0-8]|18[0-9]|19[0-2|5-9])\\d{8}))$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
