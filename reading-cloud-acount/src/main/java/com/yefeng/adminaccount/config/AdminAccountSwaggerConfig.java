package com.yefeng.adminaccount.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName AdminBookSwaggerConfig.java
 * @Description TODO swagger 配置类
 * @createTime 2022年07月19日 09:20:00
 */

@Configuration
@EnableSwagger2
public class AdminAccountSwaggerConfig {


    @Bean
    public Docket adminBookDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                // swagger 扫描 controller 包路径
                .apis(RequestHandlerSelectors.basePackage("com.yefeng.adminaccount.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("图书管理中心接口")
                .description("图书管理中心")
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))
                .license("")
                .licenseUrl("")
                .version("1.0.0")
                .build();
    }
}
