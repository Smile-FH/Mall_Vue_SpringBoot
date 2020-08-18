package com.fh.mall.service;

import com.fh.mall.entity.AdminUser;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-11 10:14
 */
public interface AdminUserService {

    AdminUser login(String loginUserName, String loginPassword);

    AdminUser getAdminUserDetailByID(int adminUserId);

    int changeAdminUserInfo(String loginUserName, String oldLoginPassword, String newLoginPassword, String nickName, int adminUserId);
}
