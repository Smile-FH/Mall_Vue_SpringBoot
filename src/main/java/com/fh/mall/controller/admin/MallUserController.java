package com.fh.mall.controller.admin;

import com.fh.mall.service.MallUserService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description: 商城普通用户信息控制层
 * @Author HueFu
 * @Date 2020-8-11 10:00
 */
@Api(tags = "后台用户管理接口")
@Controller
@RequestMapping("/admin")
public class MallUserController {

    @Autowired
    private MallUserService mallUserService;

    @ApiIgnore
    @GetMapping("/users")
    public String users(HttpServletRequest request){
        request.setAttribute("path","users");
        return "admin/mall_user";
    }

    @ApiOperation(value = "用户分页查询接口")
    @GetMapping("/users/list")
    @ResponseBody
    public Result userList(@RequestParam Map<String, Object> params){
        PageQueryUtil queryUtil = new PageQueryUtil(params);
        return ResultGenerator.getSuccessResult(mallUserService.getListMallUser(queryUtil));
    }

    @ApiOperation(value = "用户锁定接口")
    @PostMapping("/users/lock/{lockStatus}")
    @ResponseBody
    public Result userLock(@RequestBody Integer[] ids, @PathVariable int lockStatus){
        if (ObjectUtils.isEmpty(ids)) {
            return ResultGenerator.getFailResult("选中为空啊");
        } else if (ObjectUtils.isEmpty(lockStatus)) {
            return ResultGenerator.getFailResult("状态码为空啊，咋设置咧？");
        }
        int i = mallUserService.lockUser(ids, lockStatus);

        return ResultGenerator.getSuccessResult(i);
    }
}
