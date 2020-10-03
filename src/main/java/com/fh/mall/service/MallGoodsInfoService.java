package com.fh.mall.service;

import com.fh.mall.entity.MallGoodsInfo;

/**
 * Description: 商品信息的业务层接口
 *
 * @Author: HueFu
 * @Date: 2020-10-03 21:17
 */
public interface MallGoodsInfoService {


    int deleteByPrimaryKey(Integer goodId);

    int insert(MallGoodsInfo record);

    int insertSelective(MallGoodsInfo record);

    MallGoodsInfo selectByPrimaryKey(Integer goodId);

    int updateByPrimaryKeySelective(MallGoodsInfo record);

    int updateByPrimaryKey(MallGoodsInfo record);

}
