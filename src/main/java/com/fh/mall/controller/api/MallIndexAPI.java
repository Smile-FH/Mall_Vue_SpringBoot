package com.fh.mall.controller.api;

import com.fh.mall.controller.api.vo.IndexInfoVO;
import com.fh.mall.controller.api.vo.MallIndexCarouselVO;
import com.fh.mall.service.MallCarouselService;
import com.fh.mall.utils.ConstantsValue;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO(这里用一句话描述这个类的作用)
 *
 * @Author: HueFu
 * @Date: 2020-8-24 15:55
 */
@RestController
@Api(tags = "1. 商城首页接口")
@RequestMapping("/api/mall")
public class MallIndexAPI {

    @Autowired
    private MallCarouselService mallCarouselService;

    @GetMapping("/index-infos")
    @ApiOperation(value = "获取页面数据", tags = "轮播图、")
    public Result indexInfo(){
        System.out.println("请求过来了");
        IndexInfoVO indexInfoVO = new IndexInfoVO();
        List<MallIndexCarouselVO> carousels = mallCarouselService.getCarouselsForIndex(ConstantsValue.indexCarouselNumber);
        indexInfoVO.setIndexCarouselVOS(carousels);
        return ResultGenerator.getSuccessResult(indexInfoVO);
    }


}
