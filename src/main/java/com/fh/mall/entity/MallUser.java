package com.fh.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description: MallUser JavaBean
 * @Author HueFu
 * @Date 2020-8-2 9:51
 */
@Data
public class MallUser {

    private int userId;

    private String nickName;

    private String loginName;

    private String passwordMd5;

    private String introduceSign;

    private String address;

    private int isDeleted;

    private int lockedFlag;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC+8")
    private Timestamp createTime;

}
