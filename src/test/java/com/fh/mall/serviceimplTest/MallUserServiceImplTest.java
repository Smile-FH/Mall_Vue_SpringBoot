package com.fh.mall.serviceimplTest;

import com.fh.mall.service.impl.MallUserServiceImpl;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-11 15:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallUserServiceImplTest {

    @Autowired
    private MallUserServiceImpl mallUserService;

    @Test
    public void getListMallUser(){
        Map<String, Object> params = new HashMap<>();
        params.put("page",1);
        params.put("limit", 5);
        PageQueryUtil queryUtil = new PageQueryUtil(params);
//        PageResult listMallUser = mallUserService.getListMallUser(queryUtil);
        Result<Object> successResult = ResultGenerator.getSuccessResult(mallUserService.getListMallUser(queryUtil));
        System.out.println(successResult.toString());
    }
}
