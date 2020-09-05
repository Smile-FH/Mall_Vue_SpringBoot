package com.fh.mall.dao;

import com.fh.mall.entity.MallUserToken;
import java.util.List;

/** 
 * Description: user_token的持久层接口
 * @Author: HueFu
 * @Date: 2020-8-31 9:15 
 */
public interface MallUserTokenMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MallUserToken record);

    /**
     * select by primary key
     * @param token primary key
     * @return object by primary key
     */
    MallUserToken selectByPrimaryToken(String token);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MallUserToken record);

    int updateBatch(List<MallUserToken> list);

    MallUserToken selectByPrimaryKey(Integer userId);

    int deletedByPrimaryKey(int userId);

}