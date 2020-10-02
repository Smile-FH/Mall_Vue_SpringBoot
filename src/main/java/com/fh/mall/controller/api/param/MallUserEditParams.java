package com.fh.mall.controller.api.param;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Description: 商城用户修改个人信息参数信息
 *
 * @Author: HueFu
 * @Date: 2020-9-6 17:24
 */
@Data
public class MallUserEditParams {

    @ApiModelProperty("用户昵称")
    @NotEmpty(message = "昵称不能为空")
    private String nickName;

    @ApiModelProperty("用户个签")
    private String introduceSign;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String newPassword;
}
