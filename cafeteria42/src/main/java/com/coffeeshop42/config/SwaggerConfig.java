package com.coffeeshop42.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(regex("/api.*"))
				.build()
				.apiInfo(info());
	}
	
	private ApiInfo info() {
		return new ApiInfo(
				"API REST SerraFut (Titulo)",
				"API REST de cadastro de jogadores(Descrisão)",
				"1.0",
				"Termos de Serviços",
				new Contact("Karine Branco", 
						"https://www.linkedin.com/in/karine-branco-087221168/",
						"thika.branco@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());
	}
}
