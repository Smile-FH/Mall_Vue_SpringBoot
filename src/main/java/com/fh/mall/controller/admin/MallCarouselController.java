package com.fh.mall.controller.admin;

import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.entity.MallCarousel;
import com.fh.mall.service.MallCarouselService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.Result;
import com.fh.mall.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description: TODO(轮播图后台管理页控制层)
 * @Author HueFu
 * @Date 2020-8-18 9:43
 */
@Controller
@RequestMapping("/admin")
public class MallCarouselController {

    @Autowired
    private MallCarouselService mallCarouselService;

    @GetMapping("/carousels")
    public String carousePage(HttpServletRequest request){
        request.setAttribute("path", "carousels");
        return "admin/mall_carousels";
    }

    @GetMapping("/carousels/list")
    @ResponseBody
    public Result carouselList(@RequestParam Map<String, Object> params){
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        return ResultGenerator.getSuccessResult(mallCarouselService.getPageCarousel(pageQueryUtil));
    }
    
    @PostMapping("/carousel/save")
    @ResponseBody
    public Result saveCarousel(@RequestBody MallCarousel mallCarousel){
        if (StringUtils.isEmpty(mallCarousel.getCarouselUrl())
                || ObjectUtils.isEmpty(mallCarousel.getCarouselRank())) {
            return ResultGenerator.getFailResult("参数为空啦！不可以噢~");
        }

        String message = mallCarouselService.insertSelective(mallCarousel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(message)) {
            return ResultGenerator.getSuccessResult(message);
        }
        return ResultGenerator.getFailResult(message);
    }

    @PostMapping("/carousel/deleted")
    @ResponseBody
    public Result delCarousel(@RequestBody Integer[] ids){
        if (ObjectUtils.isEmpty(ids)){
            return ResultGenerator.getFailResult("要删除的参数为空啊，不可以的！");
        }
        int i = mallCarouselService.delCarousel(ids);
        return ResultGenerator.getSuccessResult(i);
    }

    @PostMapping("/carousel/update")
    @ResponseBody
    public Result update(@RequestBody MallCarousel mallCarousel) {
        int i = mallCarouselService.updateByPrimaryKeySelective(mallCarousel);
        if (i <= 0){
            return ResultGenerator.getFailResult("更新出错啦");
        }
        return ResultGenerator.getSuccessResult(i);
    }
    
}
