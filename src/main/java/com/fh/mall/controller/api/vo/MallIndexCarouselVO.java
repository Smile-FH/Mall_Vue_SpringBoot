package com.fh.mall.controller.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: vue端首页展示的轮播图需要的数据
 *
 * @Author: HueFu
 * @Date: 2020-8-24 15:49
 */
@ApiModel("Vue商城端首页轮播图数据对象")
@Data
public class MallIndexCarouselVO implements Serializable {

    @ApiModelProperty("轮播图图片地址")
    private String carouselUrl;

    @ApiModelProperty("点击轮播图跳转地址")
    private String redirectUrl;
}
