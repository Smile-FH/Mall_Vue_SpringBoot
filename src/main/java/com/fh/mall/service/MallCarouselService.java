package com.fh.mall.service;

import com.fh.mall.entity.MallCarousel;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;

/**
 * @Description: 轮播图后台业务接口
 * @Author HueFu
 * @Date 2020-8-18 10:35 
 */
public interface MallCarouselService{


    /**
     * 通过id字段删除单条轮播图业务接口
     * @param carouselId
     * @return
     */
    int deleteByPrimaryKey(Integer carouselId);

    /**
     * 新增一条轮播图业务接口
     * @param record
     * @return
     */
    int insert(MallCarousel record);

    /**
     * 只提供必要的轮播图信息就能添加轮播图的业务接口
     * @param record
     * @return
     */
    String insertSelective(MallCarousel record);

    /**
     * 通过id查询轮播图信息的业务接口
     * @param carouselId
     * @return
     */
    MallCarousel selectByPrimaryKey(Integer carouselId);

    /**
     * 通过id选择性更新轮播图信息的业务接口
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MallCarousel record);

    /**
     * 通过id更新单条轮播图所有信息的业务接口
     * @param record
     * @return
     */
    int updateByPrimaryKey(MallCarousel record);

    /**
     * 轮播图的分页数据业务接口
     * @param pageQueryUtil
     * @return
     */
    PageResult getPageCarousel(PageQueryUtil pageQueryUtil);

    /**
     * Batch Deletion Service Interface
     * @param ids
     * @return
     */
    int delCarousel(Integer[] ids);

}
