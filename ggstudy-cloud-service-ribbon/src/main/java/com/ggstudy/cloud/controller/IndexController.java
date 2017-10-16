package com.ggstudy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggstudy.cloud.service.IBalanceService;

@RestController
public class IndexController {

	@Autowired
	private IBalanceService balanceService;

	@RequestMapping("/port")
	public String getPort() {
		return balanceService.getPort();
	}
}
