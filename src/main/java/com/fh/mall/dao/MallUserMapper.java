package com.fh.mall.dao;

import com.fh.mall.entity.MallUser;import org.apache.ibatis.annotations.Param;
import java.util.List;import java.util.Map;

/**
 * Description: TODO(商城用户持久层接口)
 *
 * @Author: HueFu
 * @Date: 2020-8-30 22:44
 */
public interface MallUserMapper {
    /**
     * delete by primary key
     *
     * @param userId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MallUser record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MallUser record);

    /**
     *
     * @param loginName
     * @param passwordMd5
     * @return
     */
    MallUser selectByLoginNameAndPassword(
            @Param("loginName") String loginName,
            @Param("passwordMd5") String passwordMd5
    );

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MallUser record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MallUser record);

    int updateBatch(List<MallUser> list);

    List<MallUser> queryAll();/**
     * @Description: 查询用户表中所有的用户数据
     * @Author: HueFu
     * @Date: 2020-8-2 14:50
     * @MethodName: queryAll
     * @Param: []
     * @Return: java.util.List<com.fh.mall.entity.User>
     */

    int insertUser(MallUser user)/**
     * @Description: 添加一个用户进数据库用户表
     * @Author: HueFu
     * @Date: 2020-8-2 14:50
     * @MethodName: insertUser
     * @Param: [user]
     * @Return: int
     */
    ;

    int updateUser(MallUser user)/**
     * @Description: 更新一个单一的用户数据
     * @Author: HueFu
     * @Date: 2020-8-2 14:52
     * @MethodName: updateUser
     * @Param: [user]
     * @Return: int
     */
    ;

    int deleteUser(MallUser user)/**
     * @Description: 删除一个用户
     * @Author: HueFu
     * @Date: 2020-8-2 14:54
     * @MethodName: deleteUset
     * @Param: [user]
     * @Return: int
     */
    ;

    List<MallUser> getPageUser(@Param("pageParam") Map<String, Object> pageParam);
    /**
     * @Description: 分页查询User表
     * @Author: HueFu
     * @Date: 2020-8-10 15:50
     * @MethodName: getPageUser
     * @Param: [pageParam]
     * @Return: java.util.List<com.fh.mall.entity.User>
     */

    int getTotalUser();
    /**
    * @Description: 查询用户表的用户总数
    * @Author: HueFu
    * @Date: 2020-8-10 14:19
    * @MethodName: getTotalUser
    * @Param: []
    * @Return: int
    */

     /*
     * 锁定用户的mapper接口
     * @param lockParams
     * @return
     */
    int lockUser(@Param("lockParams") Map<String, Object> lockParams);

    MallUser selectByPrimaryKey(Integer userId);
}