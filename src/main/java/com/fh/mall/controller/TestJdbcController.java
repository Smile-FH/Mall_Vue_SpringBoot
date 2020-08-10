package com.fh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 10:42
 */
//@RestController
public class TestJdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/queryAll")
    public List<Map<String, Object>> queryAll(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from mall.mall_user");
        return maps;
    }
    
    @GetMapping("/insert")
    public int insertUser(){
        int update = jdbcTemplate.update("insert into mall.mall_user(nick_name) values('Smile1')");
        return update;
    }
}
