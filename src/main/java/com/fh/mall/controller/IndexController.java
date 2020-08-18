package com.fh.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author HueFu
 * @Date 2020-8-2 9:50
 */
@Controller
public class IndexController {
    @GetMapping("/admin")
    public String admin(){
        return "admin/index-all";
    }
}
