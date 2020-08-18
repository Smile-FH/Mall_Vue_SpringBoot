package com.fh.mall.daoTest;

import com.fh.mall.dao.MallUserMapper;
import com.fh.mall.entity.MallUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: mallUserDao Interface Test Class
 * @Author HueFu
 * @Date 2020-8-10 14:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallUserMapperTest {

    @Resource
    private MallUserMapper mallUserMapper;

    @Test
    public void getTotalUserTest(){
        int totalUser = mallUserMapper.getTotalUser();
        System.out.println(totalUser);
    }

    @Test
    public void getPageUserTest(){
        Map<String, Object> getPageParam = new HashMap<>();
        getPageParam.put("start", 0);
        getPageParam.put("limit",5);
        List<MallUser> pageUser = mallUserMapper.getPageUser(getPageParam);
        for (MallUser u :
                pageUser) {
            System.out.println(u.toString());
        }
    }
}
