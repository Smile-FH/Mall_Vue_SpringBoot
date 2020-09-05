package com.fh.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * Description: TODO(这里用一句话描述这个类的作用)
 *
 * @Author: HueFu
 * @Date: 2020-8-30 22:44
 */
@ApiModel(value = "com-fh-mall-entity-MallUser", description = "商城用户的DO实体类")
@Data
public class MallUser {
    @ApiModelProperty(value = "",example = "0")
    private Integer userId;

    @ApiModelProperty(value = "")
    private String nickName;

    @ApiModelProperty(value = "")
    private String loginName;

    @ApiModelProperty(value = "")
    private String passwordMd5;

    @ApiModelProperty(value = "")
    private String introduceSign;

    @ApiModelProperty(value = "")
    private String address;

    @ApiModelProperty(value = "",example = "0")
    private Byte isDeleted;

    @ApiModelProperty(value = "", example = "0")
    private Byte lockedFlag;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss", timezone = "UTC+8")
    @ApiModelProperty(value = "")
    private Date createTime;
}