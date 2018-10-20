package com.supermonk.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${spring.application.name}")
  private String appName;

  @Value("${env}")
  private String env;

  public static final String VERSION = "1.0.0";
  public static final String PUBLIC_API = "public-api";


  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName(PUBLIC_API).apiInfo(supermonkInfo()).select()
        .paths(PathSelectors.any()).build();
  }

  private ApiInfo supermonkInfo() {
    return new ApiInfoBuilder().title(appName + " " + VERSION + " " + env)
        .description("Swagger for " + appName + " " + VERSION + " " + env).termsOfServiceUrl("")
        .license("").licenseUrl("").version("").build();
  }

}
