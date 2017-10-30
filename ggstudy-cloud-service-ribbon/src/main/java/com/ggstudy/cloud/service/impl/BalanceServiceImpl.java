package com.ggstudy.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ggstudy.cloud.service.IBalanceService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BalanceServiceImpl implements IBalanceService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallBackMethod")
	@Override
	public String getPort() {
		String res = restTemplate.getForObject("http://eureka-client/port", String.class);
		return res;
	}

	public String fallBackMethod() {
		return "error!";
	}
}
