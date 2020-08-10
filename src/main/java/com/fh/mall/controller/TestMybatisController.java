package com.fh.mall.controller;

import com.fh.mall.dao.UserMapper;
import com.fh.mall.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 12:03
 */
@RestController
public class TestMybatisController {

    @Resource
    private UserMapper userMapper;
    
    @GetMapping("/queryAll")
    public List<User> queryAll(){
        List<User> maps = userMapper.queryAll();
        return maps;
    }


    @GetMapping("/insert")
    public int insertUser(User user){
        int i = userMapper.insertUser(user);
        return i;
    }

    @GetMapping("/updateUser")
    public int updateUser(User user){
        int i = userMapper.updateUser(user);
        return i;
    }

    @GetMapping("/deleteUser")
    public int deleteUset(User user){
        int i = userMapper.deleteUset(user);
        return i;
    }
}
