package com.fh.mall.controller.api;

import com.fh.mall.common.MallCategoryLevelEnum;
import com.fh.mall.controller.api.vo.MallClassifyFirstLevelVo;
import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.service.MallGoodsCategoryService;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 前台分类页面的控制层接口
 *
 * @Author: HueFu
 * @Date: 2020-10-10 20:06
 */
@RestController
@Api(tags = "分类页面控制层接口")
@RequestMapping("/mall/api")
public class MallClassifyApi {

    @Autowired
    private MallGoodsCategoryService mallGoodsCategoryService;

    @ApiOperation(value = "获取分类列表数据")
    @GetMapping("/classify")
    public Result getClassifyList(){
        List<MallClassifyFirstLevelVo> categoryListByLevel = this.mallGoodsCategoryService.getCategoryListByLevel();
        return ResultGenerator.getSuccessResult(categoryListByLevel);
    }
}
