package com.fh.mall.service;

import com.fh.mall.dao.UserMapper;
import com.fh.mall.entity.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 9:52
 */
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getPageUser(int start, int limit){
        Map<String, Object> pageParam = new HashMap<>();
        pageParam.put("start",start);
        pageParam.put("limit",limit);
        return userMapper.getPageUser(pageParam);
    }


    public int getTotalUser(){
        return userMapper.getTotalUser();
    }
}
