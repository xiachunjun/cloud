package com.ggstudy.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@Value("${server.port}")
	private String port;

	@RequestMapping("/port")
	public String port(String name) {
		return "eureka-client[port]=" + port;
	}

	@RequestMapping("/index")
	public String index(String name) {
		return "hello:" + name;
	}
}
