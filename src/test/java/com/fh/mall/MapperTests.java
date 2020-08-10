package com.fh.mall;

import com.fh.mall.dao.AdminUserMapper;
import com.fh.mall.entity.AdminUser;
import com.fh.mall.service.AdminUserService;
import com.fh.mall.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-8 20:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTests {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserService adminUserService;

    @Test
    public void loginTest(){
        String password = MD5Util.MD5Encode("123456", "UTF-8");
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("adminUserName", "admin");
        AdminUser one = adminUserMapper.query(queryParam);
        System.out.println(one.toString());
    }

    @Test
    public void updateMapperTest(){
        String password = MD5Util.MD5Encode("123456", "UTF-8");
        System.out.println(password);
//        Map<String, Object> updateParam = new HashMap<>();
//        updateParam.put("loginUserName", "admin");
//        updateParam.put("loginPassword",password);
//        updateParam.put("nickName", "HueFu");
//        updateParam.put("adminUserId",1);
//        int update = adminUserMapper.update(updateParam);
//        System.out.println(update);
    }
    
    @Test
    public void updateServiceTest(){
    }
}
