package com.fh.mall.controller;

import com.fh.mall.dao.MallUserMapper;
import com.fh.mall.entity.MallUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author HueFu
 * @Date 2020-8-2 12:03
 */
@RestController
public class TestMybatisController {

    @Resource
    private MallUserMapper mallUserMapper;
    
    @GetMapping("/queryAll")
    public List<MallUser> queryAll(){
        List<MallUser> maps = mallUserMapper.queryAll();
        return maps;
    }


    @GetMapping("/insert")
    public int insertUser(MallUser user){
        int i = mallUserMapper.insertUser(user);
        return i;
    }

    @GetMapping("/updateUser")
    public int updateUser(MallUser user){
        int i = mallUserMapper.updateUser(user);
        return i;
    }

    @GetMapping("/deleteUser")
    public int deleteUset(MallUser user){
        int i = mallUserMapper.deleteUset(user);
        return i;
    }
}
