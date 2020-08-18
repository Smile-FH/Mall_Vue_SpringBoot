package com.fh.mall.serviceimplTest;

import com.fh.mall.service.MallCarouselService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: carousel业务层测试类
 * @Author HueFu
 * @Date 2020-8-18 11:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallCarouselImplTest {

    @Autowired
    private MallCarouselService mallCarouselService;
    @Test
    public void getPageCarousel(){
        /**
         * @Description: 测试持久层分页功能是否完善
         * @Author: HueFu
         * @Date: 2020-8-18 11:37
         * @MethodName: getPageCarousel
         * @Param: []
         * @Return: void
         */
        Map<String, Object> map = new HashMap<>();
        map.put("page", 1);
        map.put("limit",3);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(map);
        PageResult pageCarousel = mallCarouselService.getPageCarousel(pageQueryUtil);
        System.out.println(pageCarousel.toString());
    }
}
