package com.core.check.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class Check {
	
	@GetMapping("heathly")
	public String HealthlyCheck() {
		return "Heathly good !!!";
	}
}
