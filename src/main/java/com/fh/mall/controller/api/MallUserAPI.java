package com.fh.mall.controller.api;

import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.config.annotation.TokenToMallUser;
import com.fh.mall.controller.api.param.MallUserLoginParams;
import com.fh.mall.entity.MallUser;
import com.fh.mall.service.MallUserService;
import com.fh.mall.utils.ConstantsValue;
import com.fh.mall.utils.NumUtils;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * Description: TODO(Vue商城用户功能接口)
 *
 * @Author: HueFu
 * @Date: 2020-8-30 19:50
 */
@RestController
@Api(tags = "Vue商城用户功能接口")
@RequestMapping("/mall/api")
public class MallUserAPI {

    @Autowired
    private MallUserService mallUserService;

    @ApiOperation(value = "用户登录后台接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mallUserLoginParams", value = "商城用户的账户和md5加密密码")
    })
    @PostMapping("/user/login")
    public Result login(@RequestBody @Valid MallUserLoginParams mallUserLoginParams){
        if (!NumUtils.isPhone(mallUserLoginParams.getLoginName())){
            System.out.println(mallUserLoginParams.getLoginName());
            return ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }
        String loginResult = mallUserService.userLogin(mallUserLoginParams.getLoginName(), mallUserLoginParams.getPasswordMD5());
        // 登录成功
        if (!StringUtils.isEmpty(loginResult) && loginResult.length() == ConstantsValue.tokenLength) {
            Result result = ResultGenerator.getSuccessResult("");
            result.setData(loginResult);
            return result;
        }
        // 登录失败
        return ResultGenerator.getFailResult(loginResult);
    }

    @ApiOperation(value = "用户退出登录", notes = "清除token")
    @DeleteMapping("/user")
    public Result logout(@TokenToMallUser @ApiIgnore MallUser malluser){
        Boolean userLogout = mallUserService.userLogout(malluser.getUserId());
        if (userLogout){
            return ResultGenerator.getSuccessResult("");
        }
        return ResultGenerator.getFailResult("logout error");
    }


    @ApiOperation(value = "获取当前用户的登录信息")
    @GetMapping("/user")
    public Result userInfo(@TokenToMallUser @ApiIgnore MallUser mallUser){
        return ResultGenerator.getSuccessResult(mallUser);
    }


}
