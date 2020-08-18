package com.fh.mall.controller.admin;

import com.fh.mall.service.MallUserService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description: TODO(获取商城普通用户信息的接口)
 * @Author HueFu
 * @Date 2020-8-11 10:00
 */
@Controller
@RequestMapping("/admin")
public class MallUserController {

    @Autowired
    private MallUserService mallUserService;

    @GetMapping("/users")
    public String users(HttpServletRequest request){
        request.setAttribute("path","users");
        return "admin/mall_user";
    }

    @GetMapping("/users/list")
    @ResponseBody
    public Result userList(@RequestParam Map<String, Object> params){
        PageQueryUtil queryUtil = new PageQueryUtil(params);
        return ResultGenerator.getSuccessResult(mallUserService.getListMallUser(queryUtil));
    }
}
