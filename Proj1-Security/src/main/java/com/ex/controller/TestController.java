package com.ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/re")
public class TestController {
	
	@GetMapping("/test")
	public String getMethodName() {
		return "hello";
	}
	
	@GetMapping("/admin/order")
	public String getAdminOrderDetails() {
		return "admin Oder Details";
	}
	
	@GetMapping("/user/order")
	public String getUserOrderDetails() {
		return "user Oder Details";
	}
	

}
