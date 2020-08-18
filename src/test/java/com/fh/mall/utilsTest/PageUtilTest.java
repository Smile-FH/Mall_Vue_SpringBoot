package com.fh.mall.utilsTest;

import com.fh.mall.utils.PageQueryUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: PageUtil function test class
 * @Author HueFu
 * @Date 2020-8-11 9:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageUtilTest {
    @Test
    public void pageUtilTest(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("limit", 10);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        System.out.println(pageQueryUtil.toString());
    }
}
