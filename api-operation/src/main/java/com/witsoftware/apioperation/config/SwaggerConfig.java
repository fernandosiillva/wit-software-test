package com.witsoftware.apioperation.config;

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

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.witsoftware.apioperation.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
    }
	
	public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                        .version("1.0.0")
                        .title("Api-operation to calculate")
                        .description("Application with calculator operations")
                        .contact(contact())
                        .build();
    }

    public Contact contact() {
        return new Contact(
                "Fernando Bezerra",
                "https://github.com/fernandosiillva/wit-software-test",
                "fernandosiillva@hotmail.com"
        );
    }
}
