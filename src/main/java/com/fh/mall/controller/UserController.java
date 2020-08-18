package com.fh.mall.controller;

import com.fh.mall.service.impl.TestUserImpl;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author HueFu
 * @Date 2020-8-2 16:05
 */
public class UserController {

    @Resource
    private TestUserImpl testUser;

    @GetMapping("/")
    public String methodsName(){
        return "userTest";
    }
    
    @GetMapping("/users/list")
    @ResponseBody
    public Result getlist(@RequestParam Map<String, Object> params){

        String page = params.get("page").toString();
        String limit = params.get("limit").toString();
        System.out.println("--------page:"+page+"--------");
        System.out.println("--------limit:"+limit+"--------");

        PageQueryUtil queryUtil = new PageQueryUtil(params);

        return ResultGenerator.getSuccessResult(testUser.getListMallUser(queryUtil));
    }
}
