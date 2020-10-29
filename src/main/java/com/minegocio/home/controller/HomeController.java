package com.minegocio.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	private String home() {
		return "/home";
	}
	
	@GetMapping("/home")
	private String home1() {
		return "/home";
	}
	
	@GetMapping("/template")
	private String template() {
		return "/template";
	}
	
	@GetMapping("/dashboard")
	private String dashboard() {
		return "/dashboard";
	}
}
