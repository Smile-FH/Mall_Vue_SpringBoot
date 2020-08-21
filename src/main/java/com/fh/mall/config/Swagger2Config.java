package com.fh.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: Swagger配置文件
 * @Author HueFu
 * @Date 2020-8-18 17:16
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api(){
        /**
         * @Description: 配置Swagger2的扫描路径以及返回信息操作
         * @Author: HueFu
         * @Date: 2020-8-19 14:36
         * @MethodName: api
         * @Param: []
         * @Return: springfox.documentation.spring.web.plugins.Docket
         */
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fh.mall.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        /**
         * @Description: 配置Swagger2页面的标题、描述信息、版本号
         * @Author: HueFu
         * @Date: 2020-8-19 14:37
         * @MethodName: apiInfo
         * @Param: []
         * @Return: springfox.documentation.service.ApiInfo
         */
        return new ApiInfoBuilder()
                .title("Swagger2-API文档")
                .description("swagger 文档bySmile、FH")
                .version("1.0")
                .build();
    }
}
