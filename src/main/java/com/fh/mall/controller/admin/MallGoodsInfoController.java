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
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MallGoodsInfoService mallGoodsInfoService;

    @Autowired
    private MallGoodsCategoryService mallGoodsCategoryService;

    /**
     * @param request
     * @return
     */
    @ApiIgnore
    @GetMapping("/goodInfo")
    public String toGoodsInfo(HttpServletRequest request, @RequestParam(value = "goodId", required = false) Integer goodId) {
        MallGoodsCategory threeLevelObj;
        MallGoodsCategory secondLevelObj;
        MallGoodsCategory tempGoodsCategory;
        Integer tempCategoryId;
        MallGoodsInfo mallGoodsInfo = null;
        Integer secondLevelId = null;
        Integer firstLevelId = null;
        List<MallGoodsCategory> firstLevelList;
        List<MallGoodsCategory> secondLevelList = null;
        List<MallGoodsCategory> thirdLevelList = null;
        Map<String, Object> map = new HashMap<>(2);
        if (null != goodId) {
            mallGoodsInfo = this.mallGoodsInfoService.selectByPrimaryKey(goodId);
            if (null != mallGoodsInfo) {
                Integer goodThreeLevelId;
                goodThreeLevelId = mallGoodsInfo.getCategoryId();
                threeLevelObj = this.mallGoodsCategoryService.selectByCategoryId(goodThreeLevelId);
                secondLevelId = threeLevelObj.getParentId();
                secondLevelObj = this.mallGoodsCategoryService.selectByCategoryId(secondLevelId);
                firstLevelId = secondLevelObj.getParentId();
            }
        }
        map.put("categoryLevel", MallCategoryLevelEnum.LEVEL_ONE.getLevel());
        map.put("parentId", null);
        firstLevelList = this.mallGoodsCategoryService.selectByLevelParentId(map);
        if (!CollectionUtils.isEmpty(firstLevelList)) {
            map.replace("categoryLevel", MallCategoryLevelEnum.LEVEL_TWO.getLevel());
            if (null != firstLevelId) {
                map.replace("parentId", firstLevelId);
            } else {
                tempGoodsCategory = firstLevelList.get(0);
                tempCategoryId = tempGoodsCategory.getCategoryId();
                map.replace("parentId", tempCategoryId);
            }
            secondLevelList = this.mallGoodsCategoryService.selectByLevelParentId(map);
            if (!CollectionUtils.isEmpty(secondLevelList)) {
                map.replace("categoryLevel", MallCategoryLevelEnum.LEVEL_THREE.getLevel());
                if (null != secondLevelId) {
                    map.replace("parentId", secondLevelId);
                } else {
                    tempGoodsCategory = secondLevelList.get(0);
                    tempCategoryId = tempGoodsCategory.getCategoryId();
                    map.replace("parentId", tempCategoryId);
                }
                thirdLevelList = this.mallGoodsCategoryService.selectByLevelParentId(map);
            }
        }
        request.setAttribute("firstLevelId", firstLevelId);
        request.setAttribute("secondLevelId", secondLevelId);
        request.setAttribute("goodInfo", mallGoodsInfo);
        request.setAttribute("secondLevel", secondLevelList);
        request.setAttribute("thirdLevel", thirdLevelList);
        request.setAttribute("firstLevel", firstLevelList);
        request.setAttribute("path", "goodInfo");
        return "admin/mall_goods_info";
    }

    /**
     * 分类列表三级联动
     *
     * @param categoryId
     * @return
     */
    @ApiOperation("分类列表三级联动")
    @GetMapping("/goodInfo/levelList")
    @ResponseBody
    public Result getListLevel(@RequestParam("categoryId") Integer categoryId) {
        MallGoodsCategory mallGoodsCategory = this.mallGoodsCategoryService.selectByCategoryId(categoryId);

        // 如果level不是一级或者二级就返回错误信息
        if (MallCategoryLevelEnum.LEVEL_ONE.getLevel() != mallGoodsCategory.getCategoryLevel().intValue() && MallCategoryLevelEnum.LEVEL_TWO.getLevel() != mallGoodsCategory.getCategoryLevel().intValue()) {
            return ResultGenerator.getFailResult("参数异常");
        }

        Map<String, Object> categoryResult = new HashMap<>(2);
        Map<String, Object> param = new HashMap<>();

        if (MallCategoryLevelEnum.LEVEL_ONE.getLevel() == mallGoodsCategory.getCategoryLevel()) {
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
    @PostMapping("/goodInfo")
    @ResponseBody
    public Result saveGoods(@RequestBody MallGoodsInfo mallGoodsInfo) {
        System.out.println("添加商品信息方法开始执行------方法入参是------mallGoodsInfo：" + mallGoodsInfo);
        int i = this.mallGoodsInfoService.insertSelective(mallGoodsInfo);
        return ResultGenerator.getSuccessResult("");
    }

    @ApiOperation("修改商品信息")
    @PutMapping("/goodInfo")
    @ResponseBody
    public Result editGoodInfo(@RequestBody MallGoodsInfo mallGoodsInfo) {
        System.out.println("the method editGoodInfo Began to run, the method param is: " + mallGoodsInfo);
        int i = this.mallGoodsInfoService.updateByPrimaryKeySelective(mallGoodsInfo);
        if (0 >= i) {
            return ResultGenerator.getFailResult("修改失败了，联系联系运维人员吧");
        }
        return ResultGenerator.getSuccessResult("修改成功");
    }

    @Override
    public String toString() {
        return "MallGoodsInfoController{" +
                "mallGoodsInfoService=" + mallGoodsInfoService +
                ", mallGoodsCategoryService=" + mallGoodsCategoryService +
                '}';
    }
}
