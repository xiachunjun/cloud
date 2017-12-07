package com.ggstudy.cloud.fallback;

import org.springframework.stereotype.Component;

import com.ggstudy.cloud.service.ICallClientService;

@Component
public class CallClientServiceFallBack implements ICallClientService{

	@Override
	public String getPortFromClientOne() {
		return "error!";
	}
}
