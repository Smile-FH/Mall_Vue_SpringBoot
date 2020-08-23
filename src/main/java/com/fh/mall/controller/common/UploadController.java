package com.fh.mall.controller.common;

import com.fh.mall.utils.GetUploadPath;
import com.fh.mall.utils.MallUtils;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Description: 上传文件控制类
 * Author: HueFu
 * Date: 2020-8-22 21:21
 * @author DELL
 */
@Controller
public class UploadController {

    @PostMapping("/upload/file")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        // 获得文件后缀suffix
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 重新生成文件名
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(simpleDateFormat.format(new Date())).append(random.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(GetUploadPath.uploadPath);
        File destFile = new File(GetUploadPath.uploadPath + newFileName);
        try {
            if (!fileDirectory.exists()){
                if (!fileDirectory.mkdir()){
                    return ResultGenerator.getFailResult("文件夹路径："+fileDirectory+" 创建失败");
                }
            }
            file.transferTo(destFile);
            Result resultSuccess = ResultGenerator.getSuccessResult();
            resultSuccess.setData(MallUtils.getHost(new URI(request.getRequestURL()+""))+"/upload/"+newFileName);
            return resultSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.getFailResult("文件上传失败啊");
        }
    }
}
