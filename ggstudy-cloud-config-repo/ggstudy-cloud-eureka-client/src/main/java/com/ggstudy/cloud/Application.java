package com.ggstudy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(Application.class);
		// sa.setAddCommandLineProperties(false);
		sa.run(args);
	}
}
