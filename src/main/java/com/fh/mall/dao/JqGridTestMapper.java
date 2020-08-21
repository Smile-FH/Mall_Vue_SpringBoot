package com.fh.mall.dao;

import com.fh.mall.entity.TestUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: 测试分页Jquery插件的一个持久层类
 * @Author HueFu
 * @Date 2020-8-11 20:38
 */
public interface JqGridTestMapper {

    List<TestUser> getPageUser(@Param("pageParam") Map<String, Object> pageParam)/**
     * @Description: 分页查询User表
     * @Author: HueFu
     * @Date: 2020-8-10 15:50
     * @MethodName: getPageUser
     * @Param: [pageParam]
     * @Return: java.util.List<com.fh.mall.entity.User>
     */;

    int getTotalUser()/**
     * @Description: 查询用户表的用户总数
     * @Author: HueFu
     * @Date: 2020-8-10 14:19
     * @MethodName: getTotalUser
     * @Param: []
     * @Return: int
     */;

}
