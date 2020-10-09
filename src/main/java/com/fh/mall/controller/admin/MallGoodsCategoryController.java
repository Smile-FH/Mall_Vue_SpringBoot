package com.fh.mall.controller.admin;

import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.service.MallGoodsCategoryService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description: 商品分类信息控制层接口
 *
 * @Author: HueFu
 * @Date: 2020-9-7 17:31
 */
@Api(tags = "管理员后台商品分类信息")
@Controller
@RequestMapping("/admin")
public class MallGoodsCategoryController {

    @Autowired
    private MallGoodsCategoryService mallGoodsCategoryService;

    @ApiIgnore
    @GetMapping("/category")
    public String toCategory(
            HttpServletRequest request,
            @RequestParam("categoryLevel") Byte categoryLevel,
            @RequestParam("parentId") Integer parentId,
            @RequestParam("backParentId") Integer backParentId) {
        request.setAttribute("categoryLevel", categoryLevel);
        request.setAttribute("parentId", parentId);
        request.setAttribute("backParentId", backParentId);
        request.setAttribute("path", "category");
        return "admin/category";
    }

    /**
     * 分类数据分页
     * @param params
     * @return
     */
    @ApiOperation(value = "分类数据分页接口")
    @GetMapping("/category/list")
    @ResponseBody
    public Result categoryList(@RequestParam Map<String, Object> params) {
        PageQueryUtil queryUtil = new PageQueryUtil(params);
        PageResult pageResult = mallGoodsCategoryService.categoryList(queryUtil);
        return ResultGenerator.getSuccessResult(pageResult);
    }

    /**
     * 添加分类数据
     * @param mallGoodsCategory
     * @return
     */
    @ApiOperation(value = "添加分类页面数据")
    @PostMapping("/category")
    @ResponseBody
    public Result addCategoryList(@RequestBody MallGoodsCategory mallGoodsCategory) {
        int i = mallGoodsCategoryService.insertSelective(mallGoodsCategory);
        if (i != 1 ) {
            return ResultGenerator.getFailResult("添加失败，请联系管理员！");
        }
        return ResultGenerator.getSuccessResult(true);
    }

    /**
     * 修改分类数据
     * @param mallGoodsCategory
     * @return
     */
    @ApiOperation(value = "修改分类数据接口")
    @PutMapping("/category")
    @ResponseBody
    public Result editCategory(@RequestBody MallGoodsCategory mallGoodsCategory){
        System.out.println(mallGoodsCategory);
        int i = mallGoodsCategoryService.updateByPrimaryKeySelective(mallGoodsCategory);
        System.out.println(i);
        if ( i != 1 ) {
            return ResultGenerator.getFailResult("更新失败，请联系管理员！");
        }
        return ResultGenerator.getSuccessResult("更新成功！");
    }
    
    
    // 批量删除分类数据

}
