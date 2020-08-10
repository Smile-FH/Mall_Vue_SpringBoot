package com.fh.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
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
