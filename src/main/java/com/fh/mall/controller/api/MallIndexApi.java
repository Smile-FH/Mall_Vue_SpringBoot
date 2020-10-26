package com.fh.mall.controller.api;

import com.fh.mall.controller.api.vo.IndexInfoVO;
import com.fh.mall.controller.api.vo.MallIndexCarouselVO;
import com.fh.mall.service.MallCarouselService;
import com.fh.mall.utils.ConstantsValue;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: Vue端商城首页控制层
 *
 * @Author: HueFu
 * @Date: 2020-8-24 15:55
 */
@RestController
@Api(tags = "Vue端商城首页接口")
@RequestMapping("/mall/api")
public class MallIndexApi {

    @Autowired
    private MallCarouselService mallCarouselService;

    @ApiOperation(value = "获取主页轮播图、商品信息")
    @GetMapping("/index-infos")
    public Result indexInfo(){
        IndexInfoVO indexInfoVO = new IndexInfoVO();
        List<MallIndexCarouselVO> carousels = mallCarouselService.getCarouselsForIndex(ConstantsValue.indexCarouselNumber);
        indexInfoVO.setIndexCarouselVOS(carousels);
        return ResultGenerator.getSuccessResult(indexInfoVO);
    }
}
