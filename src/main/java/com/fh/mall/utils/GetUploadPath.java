package com.fh.mall.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 得到配置文件中上传文件地址的工具类
 * @Description:
 * @Author: HueFu
 * @Date: 2020-8-17 22:28
 */
@Component
public class GetUploadPath {
    @Autowired
    private Environment env;

    private String uploadPath;

    public String getUploadPath() {
        this.uploadPath = env.getProperty("upload.path");
        return uploadPath;
    }

}
