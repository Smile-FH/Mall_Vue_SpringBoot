package com.fh.mall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO(首页轮播图的控制层)
 * @Author HueFu
 * @Date 2020-8-18 9:43
 */
@Controller
@RequestMapping("/admin")
public class MallCarouselController {

    @GetMapping("/carousels")
    public String carousePage(HttpServletRequest request){
        request.setAttribute("path", "carousels");
        return "admin/mall_carousels";
    }
    
}
