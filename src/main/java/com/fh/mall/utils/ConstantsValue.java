package com.fh.mall.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 得到配置文件中上传文件地址的工具类
 * @Description:
 * @Author: HueFu
 * @Date: 2020-8-17 22:28
 */
@Component
public class ConstantsValue {

    public static String uploadPath;

    public static int indexCarouselNumber;

    public static int tokenLength;

    @Value("${upload.path}")
    public void setUploadPath(String uploadPath) {
        ConstantsValue.uploadPath = uploadPath;
    }

    @Value("${index.carousel.number}")
    public void setindexCarouselNumber(int indexCarouselNumber) {
        ConstantsValue.indexCarouselNumber = indexCarouselNumber;
    }

    @Value("${token.length}")
    public void setTokenLength(int tokenLength) {
        ConstantsValue.tokenLength = tokenLength;
    }

}
