package com.tuespotsolutions;

import java.lang.ModuleLayer.Controller;
import java.util.Collections;

import javax.persistence.Entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.tuespotsolutions.entity.Student;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("My REST API", "Some custom  API created by me", "1.0", "",
				new Contact("Ravinder Kumar", "www.tuespotsolutions.com", "ravinder@tuespotsolutions.com"), "", "",
				Collections.emptyList());
	}
}
