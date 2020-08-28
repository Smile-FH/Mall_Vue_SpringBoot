package com.fh.mall.controller.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description: TODO(vue端商城主页展示数据的View Object)
 * @Author: HueFu
 * Date: 2020-8-24 15:45
 */
@Data
public class IndexInfoVO implements Serializable {

    @ApiModelProperty("轮播图列表")
    private List<MallIndexCarouselVO> indexCarouselVOS;

}