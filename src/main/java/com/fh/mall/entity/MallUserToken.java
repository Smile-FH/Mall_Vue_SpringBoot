package com.fh.mall.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/** 
 * Description: 用户Token实体类
 * @Author: HueFu
 * @Date: 2020-8-31 9:15 
 */
@ApiModel(value="com-fh-mall-entity-MallUserToken")
@Data
public class MallUserToken {
    /**
    * 用户主键id
    */
    @ApiModelProperty(value="用户主键id")
    private Integer userId;

    /**
    * 用户令牌Token（32位字符串）
    */
    @ApiModelProperty(value="用户令牌Token（32位字符串）")
    private String token;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
    * 令牌过期时间
    */
    @ApiModelProperty(value="令牌过期时间")
    private Date expireTime;
}