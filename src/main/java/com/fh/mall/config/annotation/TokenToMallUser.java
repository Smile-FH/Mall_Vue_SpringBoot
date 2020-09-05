package com.fh.mall.config.annotation;

import java.lang.annotation.*;

/**
 * Description: 自定义TokenToMallUser注解书写
 *
 * @Author: HueFu
 * @Date: 2020-8-31 22:14
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToMallUser {
    String value() default "user";
}
