package com.ggstudy.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggstudy.cloud.until.SHA1;

@RestController
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Value("${server.port}")
	private String port;
	@Value("${weixin.token}")
	private String token;

	@RequestMapping("/port")
	public String port(String name) {
		return "eureka-client[port]=" + port;
	}

	@RequestMapping("/index")
	public String index(String name) {
		return "hello:" + name;
	}

	@RequestMapping("/wx")
	public String wx(HttpServletRequest req) {
		logger.info("IndexController.wx==" + req.getRequestURL().toString());
		logger.info("IndexController.wx==" + req.getQueryString());
		return "wx";
	}

	// signature=4b956aca22cd33bbf50a1224a64a64c55380cb20&echostr=5859085693975783391&timestamp=1509352795&nonce=893320086
	@RequestMapping("/weixin")
	public String wx(String signature, String echostr, String timestamp, String nonce) {
		logger.info("IndexController.wx[signature]==" + signature);
		logger.info("IndexController.wx[echostr]==" + echostr);
		logger.info("IndexController.wx[timestamp]==" + timestamp);
		logger.info("IndexController.wx[nonce]==" + nonce);

		String resStr = null;
		try {
			String chkSignature = SHA1.getSHA1(token,timestamp,nonce);
			if (chkSignature.equals(signature)) {
				resStr = echostr;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			resStr = e.getMessage();
		}
		return resStr;

	}

}
