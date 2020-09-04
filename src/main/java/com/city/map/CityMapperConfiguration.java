package com.city.map;

import java.io.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Provides configurations
 */
@Configuration
@EnableSwagger2
public class CityMapperConfiguration {
	
	@Value("${datafile}")
	private String cityNameFile;

	@Bean
	CityService cityService() {
		CityServiceImpl cityServiceImpl = new CityServiceImpl();
		ReadCitiesFromFile.readCitesFormFile(cityServiceImpl, new File(cityNameFile));
		return cityServiceImpl;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/connected**")).build();
	}
}
