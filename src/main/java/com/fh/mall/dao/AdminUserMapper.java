package com.fh.mall.dao;

import com.fh.mall.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Description:
 * TODO(对mall_admin_user表的数据操作DAO接口，
 *      finish：通过查询管理员用户 and 更新管理员用户
 *      // todo 添加管理员)
 *
 * @Author HueFu
 * @Date 2020-8-8 20:12
 */
public interface AdminUserMapper {

    AdminUser query(@Param("queryParam") Map<String,Object> queryParam)/**
    * @Description: query data from mall_admin_user
    * @Author: HueFu
    * @Date: 2020-8-9 14:48
    * @MethodName: query
    * @Param: [queryParam]
    * @Return: com.fh.mall.entity.AdminUser
    */;

    int update(@Param("updateParam") Map<String, Object> updateParam)/**
    * @Description: update data to mall_admin_user
    * @Author: HueFu
    * @Date: 2020-8-9 15:23
    * @MethodName: update
    * @Param: [updateParam]
    * @Return: void
    */;

}
