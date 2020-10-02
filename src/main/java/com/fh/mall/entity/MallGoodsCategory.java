package com.fh.mall.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/** 
 * Description: 商品分类实体类
 * @Author: HueFu
 * @Date: 2020-9-7 17:10 
 */
@ApiModel(value="com-fh-mall-entity-MallGoodsCategory")
@Data
public class MallGoodsCategory {
    /**
    * 商品分类id
    */
    @ApiModelProperty(value="商品分类id")
    private Integer categoryId;

    /**
    * 分类级别
    */
    @ApiModelProperty(value="分类级别")
    private Byte categoryLevel;

    /**
    * 父分类ID
    */
    @ApiModelProperty(value="父分类ID")
    private Integer parentId;

    /**
    * 分类名称
    */
    @ApiModelProperty(value="分类名称")
    private String categoryName;

    /**
    * 分类排序值，越大越靠前
    */
    @ApiModelProperty(value="分类排序值，越大越靠前")
    private Integer categoryRank;

    /**
    * 删除标识字段（0-没删，1-删了）
    */
    @ApiModelProperty(value="删除标识字段（0-没删，1-删了）")
    private Byte isDeleted;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date creatTime;

    /**
    * 创建者的id
    */
    @ApiModelProperty(value="创建者的id")
    private Integer creatUser;

    /**
    * 最后一次操作数据的时间
    */
    @ApiModelProperty(value="最后一次操作数据的时间")
    private Date updateTime;

    /**
    * 最后一次更新的管理员id
    */
    @ApiModelProperty(value="最后一次更新的管理员id")
    private Integer updateUser;
}