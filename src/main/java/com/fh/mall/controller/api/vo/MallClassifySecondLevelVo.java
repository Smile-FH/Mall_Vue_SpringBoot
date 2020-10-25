package com.fh.mall.controller.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description: 分类页面中的二级分类数据对象
 *
 * @Author: HueFu
 * @Date: 2020-10-11 15:12
 */
@Data
@ApiModel
public class MallClassifySecondLevelVo {

    @ApiModelProperty("二级分类id")
    private int categoryId;

    @ApiModelProperty("二级分类的父级分类id")
    private int parentId;

    @ApiModelProperty("二级分类名称")
    private String categoryName;

    @ApiModelProperty("二级分类等级")
    private int categoryLevel;

    @ApiModelProperty("三级分类列表")
    private List<MallClassifyThirdLevelVo> mallClassifyThirdLevelVoList;
}

