package com.fh.mall.dao;

import com.fh.mall.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-8 20:12
 */
public interface AdminUserMapper {

    AdminUser query(@Param("queryParam") Map<String,Object> queryParam)/**
    * @Description: TODO(管理员表查询功能)
    * @Author: HueFu
    * @Date: 2020-8-9 14:48
    * @MethodName: query
    * @Param: [queryParam]
    * @Return: com.fh.mall.entity.AdminUser
    */;

    int update(@Param("updateParam") Map<String, Object> updateParam)/**
    * @Description: TODO(更新管理员表的数据)
    * @Author: HueFu
    * @Date: 2020-8-9 15:23
    * @MethodName: update
    * @Param: [updateParam]
    * @Return: void
    */;

}
