package com.fh.mall.dao;

import com.fh.mall.entity.MallCarousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/** 
 * @Description: 后台管理轮播图持久层
 *
 *      1. 轮播图的分页列表，
 *      2. 添加轮播图，
 *      3. 通过id修改轮播图，
 *      4. 通过id获取单个轮播图，
 * @Author HueFu
 * @Date 2020-8-18 10:35 
 */
public interface MallCarouselMapper {

    int deleteByPrimaryKey(Integer carouselId);

    int insert(MallCarousel record);

    int insertSelective(MallCarousel record);

    MallCarousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(MallCarousel record);

    int updateByPrimaryKey(MallCarousel record);

    List<MallCarousel> getPageCarousel(@Param("carouselPageParams") Map<String, Object> carouselPageParams);

    int getTotalCarousel();

    /**
     * Batch deletion
     * @param carouselParams
     * @return
     */
    int delCarousel(@Param("carouselParams")Map<String, Object> carouselParams);

    List<MallCarousel> findCarouselByNUM(@Param("number") int number);
}