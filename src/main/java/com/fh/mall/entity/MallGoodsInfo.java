package com.fh.mall.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * Description: 商品信息数据对象
 *
 * @Author: HueFu
 * @Date: 2020-10-03 21:17
 */
@ApiModel(value = "com-fh-mall-entity-MallGoodsInfo")
@Data
public class MallGoodsInfo {
    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Integer goodId;

    /**
     * 关联的分类id
     */
    @ApiModelProperty(value = "关联的分类id")
    private Integer categoryId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodName;

    /**
     * 商品简介
     */
    @ApiModelProperty(value = "商品简介")
    private String goodBrief;

    /**
     * 商品标签
     */
    @ApiModelProperty(value = "商品标签")
    private String goodTag;

    /**
     * 商品大图
     */
    @ApiModelProperty(value = "商品大图")
    private String goodMainImage;

    /**
     * 商品轮播图
     */
    @ApiModelProperty(value = "商品轮播图")
    private String goodCarousel;

    /**
     * 商品详情
     */
    @ApiModelProperty(value = "商品详情")
    private String goodDetailContent;

    /**
     * 商品原来售价
     */
    @ApiModelProperty(value = "商品原来售价")
    private Integer originalPrice;

    /**
     * 商品实际售价
     */
    @ApiModelProperty(value = "商品实际售价")
    private Integer shellPrice;

    /**
     * 商品库存
     */
    @ApiModelProperty(value = "商品库存")
    private Integer goodInventory;

    /**
     * 商品是否上架0-下架 1-上架
     */
    @ApiModelProperty(value = "商品是否上架0-下架 1-上架")
    private Byte isShelves;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建者id
     */
    @ApiModelProperty(value = "创建者id")
    private Integer createId;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 修改者id
     */
    @ApiModelProperty(value = "修改者id")
    private Integer updateId;
}