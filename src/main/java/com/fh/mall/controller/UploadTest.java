package com.fh.mall.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-17 21:39
 */
@RestController
public class UploadTest {

    private static final String FILE_UPLOAD_PATH = "D:\\Picture\\project\\mall\\";

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()) {
            return "上传文件为空，上传失败";
        }
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(simpleDateFormat.format(new Date())).append(random.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
            Files.write(path,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功啦，图片地址是：/upload/"+newFileName;
    }
}
