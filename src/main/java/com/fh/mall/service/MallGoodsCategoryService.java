package com.fh.mall.service;

import java.util.List;
import java.util.Map;

import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;

/**
 * Description: 商品分类业务接口
 * @Author: HueFu
 * @Date: 2020-9-7 17:10 
 */
public interface MallGoodsCategoryService{


    int deleteByPrimaryKey(Integer categoryId);

    /**
     * 根据Id获得分类
     * @param categoryId
     * @return
     */
    MallGoodsCategory selectByCategoryId(Integer categoryId);

    int insert(MallGoodsCategory record);

    int insertSelective(MallGoodsCategory record);

    List<MallGoodsCategory> selectByLevelParentId(Map<String, Object> param);

    int updateByPrimaryKeySelective(MallGoodsCategory record);

    int updateByPrimaryKey(MallGoodsCategory record);

    int updateBatch(List<MallGoodsCategory> list);

    int batchInsert(List<MallGoodsCategory> list);

    /**
     * 获得列表数据
     * @param params
     * @return PageResult
     */
    PageResult categoryList(PageQueryUtil params);
}
