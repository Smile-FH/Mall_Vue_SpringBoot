package com.fh.mall.controller.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * Description: 商城用户登录时所需的参数Param
 *
 * @Author: HueFu
 * @Date: 2020-9-5 9:36
 */
@Data
public class MallUserLoginParams {

    @ApiModelProperty("登录用户的用户名")
    @NotEmpty(message = "登录名不能为空")
    private String loginName;

    @ApiModelProperty("登录用户的用户密码")
    @NotEmpty(message = "密码能为空？")
    private String passwordMD5;

}
