package com.fh.mall.service.impl;

import com.fh.mall.dao.AdminUserMapper;
import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import com.fh.mall.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-8 20:22
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;
    
    @Override
    public AdminUser login(String loginUserName, String loginPassword){
        loginPassword = MD5Util.MD5Encode(loginPassword, "UTF-8");
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("loginUserName", loginUserName);
        queryParam.put("loginPassword", loginPassword);
        return adminUserMapper.query(queryParam);
    }
    
    @Override
    public AdminUser getAdminUserDetailByID(int adminUserId){
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("adminUserId", adminUserId);
        return adminUserMapper.query(queryParam);
    }

    @Override
    public int changeAdminUserInfo(String loginUserName, String oldLoginPassword, String newLoginPassword, String nickName, int adminUserId){
        AdminUser adminUserDetailByID = this.getAdminUserDetailByID(adminUserId);
        String originalPassword = adminUserDetailByID.getLoginPassword();
        oldLoginPassword = MD5Util.MD5Encode(oldLoginPassword, "UTF-8");
        if (!originalPassword.equals(oldLoginPassword)) {
            return 2;
        }
        if (adminUserDetailByID.getLoginUserName().equals(loginUserName)){
            loginUserName = null;
        } else if (adminUserDetailByID.getNickName().equals(nickName)){
            nickName = null;
        }
        Map<String, Object> updateParam = new HashMap<>();
        updateParam.put("loginUserName", loginUserName);
        updateParam.put("loginPassword", newLoginPassword);
        updateParam.put("nickName", nickName);
        updateParam.put("adminUserId",adminUserId);
        return adminUserMapper.update(updateParam);
    }

}
