package com.fh.mall.service.impl;

import com.fh.mall.dao.MallGoodsCategoryMapper;
import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.service.MallGoodsCategoryService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Description: 商品分类业务实现类
 * @Author: HueFu
 * @Date: 2020-9-7 17:10 
 */
@Service
public class MallGoodsCategoryServiceImpl implements MallGoodsCategoryService{

    @Resource
    private MallGoodsCategoryMapper mallGoodsCategoryMapper;

    public MallGoodsCategoryServiceImpl() {
    }

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return mallGoodsCategoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public MallGoodsCategory selectByCategoryId(Integer categoryId){
        return mallGoodsCategoryMapper.selectByCategoryId(categoryId);
    }

    @Override
    public int insert(MallGoodsCategory record) {
        return mallGoodsCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(MallGoodsCategory record) {
        return mallGoodsCategoryMapper.insertSelective(record);
    }

    @Override
    public List<MallGoodsCategory> selectByLevelParentId(Map<String, Object> param) {
        return mallGoodsCategoryMapper.selectByLevelParentId(param);
    }

    @Override
    public int updateByPrimaryKeySelective(MallGoodsCategory record) {
        return mallGoodsCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MallGoodsCategory record) {
        return mallGoodsCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MallGoodsCategory> list) {
        return mallGoodsCategoryMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<MallGoodsCategory> list) {
        return mallGoodsCategoryMapper.batchInsert(list);
    }

    @Override
    public PageResult categoryList(PageQueryUtil params) {
        int totalCategory = mallGoodsCategoryMapper.getTotalCategory();
        List<MallGoodsCategory> mallGoodsCategories = mallGoodsCategoryMapper.categoryList(params);
        PageResult pageResult = new PageResult(totalCategory, mallGoodsCategories, params.getLimit(), params.getPage());
        return pageResult;
    }

    @Override
    public String toString() {
        return "MallGoodsCategoryServiceImpl{" +
                "mallGoodsCategoryMapper=" + mallGoodsCategoryMapper +
                '}';
    }
}
