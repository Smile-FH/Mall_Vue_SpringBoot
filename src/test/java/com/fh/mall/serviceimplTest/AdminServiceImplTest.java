package com.fh.mall.serviceimplTest;

import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 管理员用户测试类
 * @Author HueFu
 * @Date 2020-8-12 8:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {

    @Autowired
    private AdminUserService adminUserService;

    @Test
    public void login(){
        AdminUser adminUserDetailByID = adminUserService.login("admin", "123456");
        System.out.println(adminUserDetailByID.toString());
    }

}
