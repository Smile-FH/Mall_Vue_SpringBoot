package com.fh.mall.service.impl;

import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fh.mall.entity.MallCarousel;
import com.fh.mall.dao.MallCarouselMapper;
import com.fh.mall.service.MallCarouselService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: carousel业务层实现类
 * @Author HueFu
 * @Date 2020-8-18 10:35 
 */
@Service
public class MallCarouselServiceImpl implements MallCarouselService{

    @Resource
    private MallCarouselMapper mallCarouselMapper;

    @Override
    public int deleteByPrimaryKey(Integer carouselId) {
        return mallCarouselMapper.deleteByPrimaryKey(carouselId);
    }

    @Override
    public int insert(MallCarousel record) {
        return mallCarouselMapper.insert(record);
    }

    @Override
    public String insertSelective(MallCarousel record) {
        if (mallCarouselMapper.insertSelective(record)>0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public MallCarousel selectByPrimaryKey(Integer carouselId) {
        return mallCarouselMapper.selectByPrimaryKey(carouselId);
    }

    @Override
    public int updateByPrimaryKeySelective(MallCarousel record) {
        return mallCarouselMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MallCarousel record) {
        return mallCarouselMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getPageCarousel(PageQueryUtil pageQueryUtil) {
        List<MallCarousel> mallCarousels = mallCarouselMapper.getPageCarousel(pageQueryUtil);
        int totalCarousel = mallCarouselMapper.getTotalCarousel();
        return new PageResult(totalCarousel, mallCarousels, pageQueryUtil.getLimit(), pageQueryUtil.getCurrentPage());
    }

    @Override
    public int delCarousel(Integer[] ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        int i = mallCarouselMapper.delCarousel(params);
        return i;
    }

}
