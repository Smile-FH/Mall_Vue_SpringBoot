package com.fh.mall.entity;

import lombok.Data;

/**
 * @Description: AdminUser JavaBean
 * @Author HueFu
 * @Date 2020-8-8 15:22
 */
@Data
public class AdminUser {

    private int adminUserId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private int locked;
}
