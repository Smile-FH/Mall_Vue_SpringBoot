package com.fh.mall.controller.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 三级分类数据对象
 *
 * @Author: HueFu
 * @Date: 2020-10-12 22:34
 */
@Data
@ApiModel
public class MallClassifyThirdLevelVo {

    @ApiModelProperty("三级分类的id")
    private Integer categoryId;

    @ApiModelProperty("三级分类的父级分类id")
    private int parentId;

    @ApiModelProperty("三级分类名称")
    private String categoryName;

    @ApiModelProperty("分类等级")
    private int categoryLevel;
}
