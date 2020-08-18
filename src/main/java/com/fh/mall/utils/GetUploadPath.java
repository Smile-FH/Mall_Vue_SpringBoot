package com.fh.mall.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-17 22:28
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