package com.fh.mall.config;

import com.fh.mall.interceptor.AdminLoginInterceptor;
import com.fh.mall.utils.GetUploadPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: mvc intercept configuration
 * @Author HueFu
 * @Date 2020-8-8 21:38
 */
@Configuration
public class MallWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Autowired
    private GetUploadPath getUploadPath;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * @Description: admin登录拦截配置
         * @Author: HueFu
         * @Date: 2020-8-17 22:11
         * @MethodName: addInterceptors
         * @Param: [registry]
         * @Return: void
         */
        registry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 配置静态资源目录，所有请求/upload/的资源路径都会被映射到后边的路径中，注意Linux和Win的路径写法不同
         * @Author: HueFu
         * @Date: 2020-8-17 22:16
         * @MethodName: addResourceHandlers
         * @Param: [registry]
         * @Return: void
         */
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+getUploadPath.getUploadPath());
    }
}
