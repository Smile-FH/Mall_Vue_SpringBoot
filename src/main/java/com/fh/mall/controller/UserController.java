package com.fh.mall.controller;

import com.fh.mall.dao.UserMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 16:05
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    

}
