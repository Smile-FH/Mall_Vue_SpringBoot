package com.fh.mall.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 9:51
 */
@Data
public class User {

    private int userId;

    private String nickName;

    private String loginName;

    private String passwordMd5;

    private String introduceSign;

    private String address;

    private int isDeleted;

    private int lockedFlag;

    private Timestamp createTime;

}
