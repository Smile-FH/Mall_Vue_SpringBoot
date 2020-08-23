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
public class GetUploadPath {

    public static String uploadPath;

    @Value("${upload.path}")
    public void setUploadPath(String uploadPath) {
        GetUploadPath.uploadPath = uploadPath;
    }
}
