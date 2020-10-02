package com.fh.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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
                .apis(RequestHandlerSelectors.basePackage("com.fh.mall.controller.api"))
                .paths(PathSelectors.any())
                .build()
                .groupName("商城前台接口")
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    @Bean
    public Docket docketDemo2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fh.mall.controller.admin"))
                .paths(PathSelectors.any()) //正则匹配请求路径，并分配至当前分组
                .build()
                .groupName("商城后台接口");   //分组名称;
    }

    private ApiInfo apiInfo() {
        /**
         * @Description: 配置Swagger2页面的标题、描述信息、版本号
         * @Author: HueFu
         * @Date: 2020-8-19 14:37
         * @MethodName: apiInfo
         *
         * @Param: []
         * @Return: springfox.documentation.service.ApiInfo
         */
        return new ApiInfoBuilder()
                .title("Swagger2-API文档")
                .description("swagger 文档bySmile、FH")
                .version("1.0")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        List apiKey = new ArrayList();
        apiKey.add(new ApiKey("Authorization", "token", "header"));
        return apiKey;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!login).*$")).build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

}
