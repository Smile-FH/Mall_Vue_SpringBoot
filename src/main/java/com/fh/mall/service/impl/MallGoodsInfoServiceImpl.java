package com.fh.mall.service.impl;

import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.fh.mall.entity.MallGoodsInfo;
import com.fh.mall.dao.MallGoodsInfoMapper;
import com.fh.mall.service.MallGoodsInfoService;

import java.util.List;

/**
 * Description: 商品信息的业务层实现类
 *
 * @Author: HueFu
 * @Date: 2020-10-03 21:17
 */
@Service
public class MallGoodsInfoServiceImpl implements MallGoodsInfoService {

    @Resource
    private MallGoodsInfoMapper mallGoodsInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer goodId) {
        return this.mallGoodsInfoMapper.deleteByPrimaryKey(goodId);
    }

    @Override
    public int insert(MallGoodsInfo record) {
        return this.mallGoodsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(MallGoodsInfo record) {
        return this.mallGoodsInfoMapper.insertSelective(record);
    }

    @Override
    public MallGoodsInfo selectByPrimaryKey(Integer goodId) {
        return this.mallGoodsInfoMapper.selectByPrimaryKey(goodId);
    }

    @Override
    public int updateByPrimaryKeySelective(MallGoodsInfo record) {
        return this.mallGoodsInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(MallGoodsInfo record) {
        return this.mallGoodsInfoMapper.updateByPrimaryKey(record);
    }

    /**
     * @param pageQueryUtil methods param
     * @return
     */
    @Override
    public PageResult getGoodsList(PageQueryUtil pageQueryUtil) {
        int limit = pageQueryUtil.getLimit();
        int page = pageQueryUtil.getPage();
        int totalAmountGoods = this.mallGoodsInfoMapper.getTotalAmountGoods();
        List<MallGoodsInfo> mallGoodsInfos = this.mallGoodsInfoMapper.goodsList(pageQueryUtil);
        return new PageResult(totalAmountGoods, mallGoodsInfos, limit, page);
    }

}
