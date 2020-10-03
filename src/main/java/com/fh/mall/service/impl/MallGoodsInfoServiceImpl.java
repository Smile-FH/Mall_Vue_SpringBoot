package com.fh.mall.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fh.mall.entity.MallGoodsInfo;
import com.fh.mall.dao.MallGoodsInfoMapper;
import com.fh.mall.service.MallGoodsInfoService;
/** 
 * Description: 商品信息的业务层实现类
 * @Author: HueFu
 * @Date: 2020-10-03 21:17 
 */
@Service
public class MallGoodsInfoServiceImpl implements MallGoodsInfoService{

    @Resource
    private MallGoodsInfoMapper mallGoodsInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer goodId) {
        return mallGoodsInfoMapper.deleteByPrimaryKey(goodId);
    }

    @Override
    public int insert(MallGoodsInfo record) {
        return mallGoodsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(MallGoodsInfo record) {
        return mallGoodsInfoMapper.insertSelective(record);
    }

    @Override
    public MallGoodsInfo selectByPrimaryKey(Integer goodId) {
        return mallGoodsInfoMapper.selectByPrimaryKey(goodId);
    }

    @Override
    public int updateByPrimaryKeySelective(MallGoodsInfo record) {
        return mallGoodsInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MallGoodsInfo record) {
        return mallGoodsInfoMapper.updateByPrimaryKey(record);
    }

}
