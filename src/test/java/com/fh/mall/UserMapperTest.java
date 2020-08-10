package com.fh.mall;

import com.fh.mall.dao.UserMapper;
import com.fh.mall.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-10 14:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void getTotalUserTest(){
        int totalUser = userMapper.getTotalUser();
        System.out.println(totalUser);
    }

    @Test
    public void getPageUserTest(){
        Map<String, Object> getPageParam = new HashMap<>();
        getPageParam.put("start", 0);
        getPageParam.put("limit",5);
        List<User> pageUser = userMapper.getPageUser(getPageParam);
        for (User u :
                pageUser) {
            System.out.println(u.toString());
        }
    }
}
