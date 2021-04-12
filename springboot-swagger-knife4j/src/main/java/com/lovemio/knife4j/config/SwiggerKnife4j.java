package com.lovemio.knife4j.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
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
 * @author liwenjin
 * @date 2021年04月12日 9:53
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwiggerKnife4j {

    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("SpringBootKnife4j")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lovemio.knife4j.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("lwj","http://www.lovemio.cn","455193135@qq.com");
        return new ApiInfoBuilder()
                .title("Swigger文档")//标题
                .description("集成Swigger-kinfe4j")//文档接口描述
                .contact(contact)//联系地址
                .version("1.1.0")//版本号
                .build();
    }
}

