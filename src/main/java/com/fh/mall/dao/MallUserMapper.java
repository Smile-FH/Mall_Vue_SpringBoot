package com.fh.mall.dao;

import com.fh.mall.entity.MallUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-2 9:52
 */
public interface MallUserMapper {

    List<MallUser> queryAll()/**
    * @Description: TODO(查询用户表中所有的用户数据)
    * @Author: HueFu
    * @Date: 2020-8-2 14:50
    * @MethodName: queryAll
    * @Param: []
    * @Return: java.util.List<com.fh.mall.entity.User>
    */;

    int insertUser(MallUser user)/**
    * @Description: TODO(添加一个用户进数据库用户表)
    * @Author: HueFu
    * @Date: 2020-8-2 14:50
    * @MethodName: insertUser
    * @Param: [user]
    * @Return: int
    */;


    int updateUser(MallUser user)/**
    * @Description: TODO(更新一个单一的用户数据)
    * @Author: HueFu
    * @Date: 2020-8-2 14:52
    * @MethodName: updateUser
    * @Param: [user]
    * @Return: int
    */;

    int deleteUset(MallUser user)/**
    * @Description: TODO(删除一个用户)
    * @Author: HueFu
    * @Date: 2020-8-2 14:54
    * @MethodName: deleteUset
    * @Param: [user]
    * @Return: int
    */;

    List<MallUser> getPageUser(@Param("pageParam") Map<String, Object> pageParam)/**
    * @Description: TODO(分页查询User表)
    * @Author: HueFu
    * @Date: 2020-8-10 15:50
    * @MethodName: getPageUser
    * @Param: [pageParam] 
    * @Return: java.util.List<com.fh.mall.entity.User> 
    */;

    int getTotalUser()/** 
    * @Description: TODO(查询用户表的用户总数)
    * @Author: HueFu
    * @Date: 2020-8-10 14:19
    * @MethodName: getTotalUser
    * @Param: [] 
    * @Return: int 
    */;

}
