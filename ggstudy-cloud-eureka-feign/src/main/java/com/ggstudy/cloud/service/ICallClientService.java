package com.ggstudy.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ggstudy.cloud.fallback.CallClientServiceFallBack;

@FeignClient(value = "eureka-client", fallback = CallClientServiceFallBack.class)
public interface ICallClientService {

	@RequestMapping(value = "/port", method = RequestMethod.GET)
	String getPortFromClientOne();
}
