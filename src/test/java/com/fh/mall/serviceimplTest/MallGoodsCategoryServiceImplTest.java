package com.fh.mall.serviceimplTest;

import com.fh.mall.service.MallGoodsCategoryService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 后台分类管理页测试类
 *
 * @Author: HueFu
 * @Date: 2020-9-8 10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallGoodsCategoryServiceImplTest {

    @Autowired
    private MallGoodsCategoryService mallGoodsCategoryService;

    @Test
    public void getPageList(){
        Map<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("limit",5);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(map);
        PageResult pageResult = mallGoodsCategoryService.getCategoryList(pageQueryUtil);
        System.out.println(pageResult.toString());
    }

}
