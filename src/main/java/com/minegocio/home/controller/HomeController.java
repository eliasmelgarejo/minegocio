package com.minegocio.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	private String layout() {
		return "plantillas/layout";
	}
	
	@GetMapping("/home")
	private String home() {
		return "/home";
	}
		
	@GetMapping("/dashboard")
	private String dashboard() {
		return "/dashboard";
	}
	
	@GetMapping("/inventario")
	private String inventario(Model model) {
		model.addAttribute("modulo", "INVENTARIO");
		return "/inventario/home";
	}
}
