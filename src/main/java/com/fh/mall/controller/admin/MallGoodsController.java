package com.fh.mall.controller.admin;

import com.fh.mall.service.MallGoodsInfoService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description: 商品展示控制层接口
 *
 * @Author: HueFu
 * @Date: 2020-10-07 22:02
 */
@Api("商品信息展示")
@Controller
@RequestMapping("/admin")
public class MallGoodsController {

    @Autowired
    private MallGoodsInfoService mallGoodsInfoService;

    @ApiIgnore
    @GetMapping("/goods")
    public String toGoodHtml(HttpServletRequest request) {
        request.setAttribute("path", "goods");
        return "admin/mall_goods";
    }

    @ApiOperation("获取商品信息列表")
    @GetMapping("/goods/list")
    @ResponseBody
    public Result getGoodsList(@RequestParam Map<String, Object> param) {
        System.out.println("the method getGoodsList Began to Run, the method's param is: " + param.toString());
        PageQueryUtil pageQueryUtil = new PageQueryUtil(param);
        PageResult goodsList = this.mallGoodsInfoService.getGoodsList(pageQueryUtil);
        System.out.println("the method getGoodsList End of Run, the method's result is: " + goodsList);
        return ResultGenerator.getSuccessResult(goodsList);
    }
}
