package com.fh.mall.dao;

import com.fh.mall.entity.MallGoodsCategory;

import java.util.List;
import java.util.Map;

import com.fh.mall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

/**
 * Description: 商品分类持久层接口
 *
 * @Author: HueFu
 * @Date: 2020-9-7 17:10
 */
public interface MallGoodsCategoryMapper {
    /**
     * delete by primary key
     *
     * @param categoryId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MallGoodsCategory record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MallGoodsCategory record);

    /**
     *
     * @param param
     * @return
     */
    List<MallGoodsCategory> selectByLevelParentId(@Param("param") Map<String, Object> param);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MallGoodsCategory record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MallGoodsCategory record);

    int updateBatch(List<MallGoodsCategory> list);

    int batchInsert(@Param("list") List<MallGoodsCategory> list);

    List<MallGoodsCategory> categoryList(@Param("p") PageQueryUtil pageQueryUtil);

    int getTotalCategory();

    /**
     * 根据商品分类Id查询分类
     * @param categoryId
     * @return
     */
    MallGoodsCategory selectByCategoryId(Integer categoryId);
}