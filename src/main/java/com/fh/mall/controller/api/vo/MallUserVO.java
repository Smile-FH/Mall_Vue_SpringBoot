package com.fh.mall.controller.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: Vue商城端的用户数据对象
 *
 * @Author: HueFu
 * @Date: 2020-8-30 22:05
 */
@ApiModel("Vue端的用户数据展示对象")
@Data
public class MallUserVO implements Serializable {

    @ApiModelProperty("用户登录名")
    private String loginName;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户个签")
    private String introduceSign;

}
