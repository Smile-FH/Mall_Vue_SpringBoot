package com.fh.mall.controller.admin;

import com.fh.mall.common.MallCategoryLevelEnum;
import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.entity.MallGoodsInfo;
import com.fh.mall.service.MallGoodsCategoryService;
import com.fh.mall.service.MallGoodsInfoService;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Description: 商城物品信息编辑控制层接口
 *
 * @Author: HueFu
 * @Date: 2020-09-28 08:48
 */
@Api(tags = "商城物品信息编辑")
@Controller
@RequestMapping("/admin")
public class MallGoodsInfoController {

    private final MallGoodsCategoryService mallGoodsCategoryService;

    private final MallGoodsInfoService mallGoodsInfoService;

    public MallGoodsInfoController(MallGoodsCategoryService categoryService, MallGoodsInfoService infoService) {
        this.mallGoodsCategoryService = categoryService;
        this.mallGoodsInfoService = infoService;
    }

    /**
     * @param request
     * @return
     */
    @ApiIgnore
    @GetMapping("/goods")
    public String toGoodsInfo(HttpServletRequest request) {
        request.setAttribute("path", "goods");
        Map<String, Object> map = new HashMap<>();
        map.put("categoryLevel", MallCategoryLevelEnum.LEVEL_ONE.getLevel());
        map.put("parentId", null);

        List<MallGoodsCategory> firstLevel = this.mallGoodsCategoryService.selectByLevelParentId(map);
        if (!CollectionUtils.isEmpty(firstLevel)) {
            map.replace("categoryLevel", MallCategoryLevelEnum.LEVEL_TWO.getLevel());
            map.replace("parentId", firstLevel.get(0).getCategoryId());
            List<MallGoodsCategory> secondLevel = this.mallGoodsCategoryService.selectByLevelParentId(map);
            request.setAttribute("secondLevel", secondLevel);
            if (!CollectionUtils.isEmpty(secondLevel)) {
                map.replace("categoryLevel", 3);
                map.replace("parentId", secondLevel.get(0).getCategoryId());
                List<MallGoodsCategory> thirdLevel = this.mallGoodsCategoryService.selectByLevelParentId(map);
                request.setAttribute("thirdLevel", thirdLevel);
            }
        }
        request.setAttribute("firstLevel", firstLevel);
        return "/admin/mall_goods_info";
    }
    
    @ApiOperation("获得分级列表")
    @GetMapping("/goods/levelList")
    @ResponseBody
    public Result getListLevel(@RequestParam("categoryId")Integer categoryId ){
        MallGoodsCategory mallGoodsCategory = this.mallGoodsCategoryService.selectByCategoryId(categoryId);

        // 如果level不是一级或者二级就返回错误信息
        if (MallCategoryLevelEnum.LEVEL_ONE.getLevel() != mallGoodsCategory.getCategoryLevel().intValue() && MallCategoryLevelEnum.LEVEL_TWO.getLevel() !=  mallGoodsCategory.getCategoryLevel().intValue()){
            return ResultGenerator.getFailResult("参数异常");
        }

        Map<String, Object> categoryResult = new HashMap<>(2);
        Map<String, Object> param = new HashMap<>();

        if (MallCategoryLevelEnum.LEVEL_ONE.getLevel() == mallGoodsCategory.getCategoryLevel()){
            param.put("categoryLevel", MallCategoryLevelEnum.LEVEL_TWO.getLevel());
            param.put("parentId", categoryId);
            List<MallGoodsCategory> secondList = this.mallGoodsCategoryService.selectByLevelParentId(param);
            categoryResult.put("secondList", secondList);
            param.put("categoryLevel", MallCategoryLevelEnum.LEVEL_THREE.getLevel());
            param.put("parentId", secondList.get(0).getCategoryId());
            List<MallGoodsCategory> thirdList = this.mallGoodsCategoryService.selectByLevelParentId(param);
            categoryResult.put("thirdList", thirdList);
        }

        if (MallCategoryLevelEnum.LEVEL_TWO.getLevel() == mallGoodsCategory.getCategoryLevel()) {
            // 二级分类返回该分类下的所有数据
            param.put("categoryLevel", MallCategoryLevelEnum.LEVEL_THREE.getLevel());
            param.put("parentId", categoryId);
            List<MallGoodsCategory> thirdList = this.mallGoodsCategoryService.selectByLevelParentId(param);
            categoryResult.put("thirdList", thirdList);
        }

        return ResultGenerator.getSuccessResult(categoryResult);
    }
    
    @ApiOperation("添加商品信息")
    @PostMapping("/goods")
    @ResponseBody
    public Result saveGoods(@RequestBody MallGoodsInfo mallGoodsInfo){
        System.out.println("添加商品信息方法开始执行------方法入参是------mallGoodsInfo：" + mallGoodsInfo);

//        int i = this.mallGoodsInfoService.insertSelective(mallGoodsInfo);
        return ResultGenerator.getSuccessResult("");
    }

    @Override
    public String toString() {
        return "MallGoodsInfoController{" +
                "mallGoodsCategoryService=" + this.mallGoodsCategoryService +
                '}';
    }
}
