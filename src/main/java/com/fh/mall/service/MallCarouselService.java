package com.fh.mall.service;

import com.fh.mall.entity.MallCarousel;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;

/**
 * @Description: 
 *TODO(这里用一句话描述这个类的作用) 
 * @Author HueFu
 * @Date 2020-8-18 10:35 
 */
public interface MallCarouselService{


    int deleteByPrimaryKey(Integer carouselId);

    int insert(MallCarousel record);

    String insertSelective(MallCarousel record);

    MallCarousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(MallCarousel record);

    int updateByPrimaryKey(MallCarousel record);

    PageResult getPageCarousel(PageQueryUtil pageQueryUtil);

}
