package com.ggstudy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggstudy.cloud.service.ICallClientService;

@RestController
public class CallClientController {

	@Autowired
	ICallClientService callClientService;

	@RequestMapping("/getPort")
	public String getPort(String name) {
		return callClientService.getPortFromClientOne();
	}
}
