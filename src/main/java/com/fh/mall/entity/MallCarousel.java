package com.fh.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/** 
 * @Description: carousel实体类
 * @Author HueFu
 * @Date 2020-8-18 10:35
 */
@Data
public class MallCarousel {
    /**
    * 首页轮播图主键id
    */
    private Integer carouselId;

    /**
    * 轮播图
    */
    private String carouselUrl;

    /**
    * 点击后的跳转地址(默认不跳转)
    */
    private String redirectUrl;

    /**
    * 排序值(字段越大越靠前)
    */
    private Integer carouselRank;

    /**
    * 删除标识字段(0-未删除 1-已删除)
    */
    private Byte isDeleted;

    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC+8")
    private Date createTime;

    /**
    * 创建者id
    */
    private Integer createUser;

    /**
    * 修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC+8")
    private Date updateTime;

    /**
    * 修改者id
    */
    private Integer updateUser;
}