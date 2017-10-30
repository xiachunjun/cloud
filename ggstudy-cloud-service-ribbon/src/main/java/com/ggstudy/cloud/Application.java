package com.ggstudy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class Application {
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(Application.class);
		sa.run(args);
	}

	@Bean
	@LoadBalanced // 开启器负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
