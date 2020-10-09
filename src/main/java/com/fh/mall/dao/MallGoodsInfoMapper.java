package com.fh.mall.dao;

import com.fh.mall.entity.MallGoodsInfo;
import com.fh.mall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: 商品信息持久层接口
 *
 * @Author: HueFu
 * @Date: 2020-10-03 21:17
 */
public interface MallGoodsInfoMapper {
    /**
     * delete by primary key
     *
     * @param goodId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer goodId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MallGoodsInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MallGoodsInfo record);

    /**
     * select by primary key
     *
     * @param goodId primary key
     * @return object by primary key
     */
    MallGoodsInfo selectByPrimaryKey(Integer goodId);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MallGoodsInfo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MallGoodsInfo record);

    List<MallGoodsInfo> goodsList(@Param("p")PageQueryUtil pageQueryUtil);

    /**
     * query the total number of data in the goodInfo table
     * @return
     */
    int getTotalAmountGoods();
}