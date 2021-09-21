package com.SprintProject;

import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
//	@Bean
//	public Docket api()
//	{
//		return new Docket(DocumentationType.OAS_30)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.netjstech.demo"))
//				.paths(PathSelectors.any())
//				.build().apiInfo(apiEndPointInfo());
//	}
//
//	private ApiInfo apiEndPointInfo() {
//		// TODO Auto-generated method stub
//		return new ApiInfoBuilder().title("Spring Boot Project Rest API")
//				.description("Consumer API")
//				.contact(new Contact("Netjstech","https://netjstech.com","infojtutor@gmail.com"))
//				.license("Apache 2.0")
//				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//				.version("0.0.1-SNAPSHOT")
//				.build();
//	}
}
