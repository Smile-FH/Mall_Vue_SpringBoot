package com.fh.mall.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-8 20:25
 */
public class MD5Util {

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteArrayToHexString(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(byteToHexString(bytes[i]));
        }
        return stringBuffer.toString();
    }

    private static String byteToHexString(byte b){
        int n = b;
        if (n<0){
            n += 256;
        }
        int b1 = n/16;
        int b2 = n%16;
        return hexDigits[b1] + hexDigits[b2];
    }


    public static String MD5Encode(String origin, String charsetName){
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            if (charsetName == null || charsetName.equals("")){
                resultString = byteArrayToHexString(md5.digest(resultString.getBytes()));
            }else {
                resultString = byteArrayToHexString(md5.digest(resultString.getBytes(charsetName)));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        }
        return resultString;
    }
}
