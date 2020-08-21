package com.fh.mall.service;

import com.fh.mall.entity.AdminUser;

/**
 * @Description: 管理员用户模块供控制层调用的业务层接口
 * @author HueFu
 * @Date 2020-8-11 10:14
 */
public interface AdminUserService {

    /**
     * 管理员登录业务接口
     * @param loginUserName
     * @param loginPassword
     * @return
     */
    AdminUser login(String loginUserName, String loginPassword);

    AdminUser getAdminUserDetailByID(int adminUserId);

    int changeAdminUserInfo(String loginUserName, String oldLoginPassword, String newLoginPassword, String nickName, int adminUserId);
}
