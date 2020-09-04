package com.city.map;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	// used in tests
	public static ApplicationContext appCtx;

	public static void main(String[] args) {
		appCtx = SpringApplication.run(Application.class, args);
	}
}
