package com.fh.mall.controller.admin;

import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.service.MallGoodsCategoryService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 商城物品信息编辑控制层接口
 *
 * @Author: HueFu
 * @Date: 2020-09-28 08:48
 */
@Api(tags = "商品信息编辑页")
@Controller
@RequestMapping("/admin")
public class MallGoodsInfoController {

    @Autowired
    private MallGoodsCategoryService mallGoodsCategoryService;

    /**
     * @param request
     * @return
     */
    @ApiIgnore
    @GetMapping(value = "/goods")
    public String toGoodsInfo(HttpServletRequest request) {
        request.setAttribute("path", "goods");
        Map<String, Object> map = new HashMap<>();
        map.put("categoryLevel", 1);
        map.put("parentId", null);

        List<MallGoodsCategory> firstLevel = mallGoodsCategoryService.selectByLevelParentId(map);
        if (!CollectionUtils.isEmpty(firstLevel)) {
            map.replace("categoryLevel", 2);
            map.replace("parentId", firstLevel.get(0).getCategoryId());
            List<MallGoodsCategory> secondLevel = mallGoodsCategoryService.selectByLevelParentId(map);
            request.setAttribute("secondLevel", secondLevel);
            if (!CollectionUtils.isEmpty(secondLevel)) {
                map.replace("categoryLevel", 3);
                map.replace("parentId", secondLevel.get(0).getCategoryId());
                List<MallGoodsCategory> thirdLevel = mallGoodsCategoryService.selectByLevelParentId(map);
                request.setAttribute("thirdLevel", thirdLevel);
            }
        }
        request.setAttribute("firstLevel", firstLevel);
        return "/admin/mall_goods_info";
    }
    
    @ApiOperation("获得分级列表")
    @GetMapping(value = "/goods/listLevel")
    @ResponseBody
    public Result getListLevel(@RequestParam("categoryId")Integer categoryId ){
        MallGoodsCategory mallGoodsCategory = mallGoodsCategoryService.selectByCategoryId(categoryId);
        System.out.println(mallGoodsCategory);
        return ResultGenerator.getSuccessResult("");
    }
    
    @ApiOperation("添加商品信息")
    @PostMapping("/goods")
    @ResponseBody
    public Result saveGoods(){
        return ResultGenerator.getSuccessResult("");
    }

}
