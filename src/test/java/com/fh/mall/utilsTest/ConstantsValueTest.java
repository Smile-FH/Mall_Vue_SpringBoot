package com.fh.mall.utilsTest;

import com.fh.mall.utils.ConstantsValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description: 测试GetUploadPath
 * Author: HueFu
 * Date: 2020-8-22 21:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConstantsValueTest {

    @Test
    public void methodsName(){
        System.out.println(ConstantsValue.uploadPath);
    }

}
