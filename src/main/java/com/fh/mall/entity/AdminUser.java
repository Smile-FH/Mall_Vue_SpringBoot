package com.fh.mall.entity;

import lombok.Data;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
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
