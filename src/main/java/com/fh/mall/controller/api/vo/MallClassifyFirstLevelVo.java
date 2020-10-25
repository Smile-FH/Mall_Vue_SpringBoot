package com.fh.mall.controller.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description: 前台classify的数据对象
 *
 * @Author: HueFu
 * @Date: 2020-10-11 15:03
 */
@Data
@ApiModel
public class MallClassifyFirstLevelVo {

    @ApiModelProperty("一级分类id")
    private int categoryId;

    @ApiModelProperty("一级分类父级id")
    private int parentId;

    @ApiModelProperty("一级分类level")
    private int categoryLevel;

    @ApiModelProperty("一级分类名称")
    private String categoryName;

    @ApiModelProperty("二级分类数据列表")
    private List<MallClassifySecondLevelVo> mallClassifySecondLevelVoList;

}
