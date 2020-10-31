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
	
	@GetMapping("/base")
	private String base(Model model) {
		model.addAttribute("modulo", "BASE");
		return "/base/home";
	}
	
	@GetMapping("/compras")
	private String compras(Model model) {
		model.addAttribute("modulo", "COMPRAS");
		return "/compras/home";
	}
	
	@GetMapping("/inventario")
	private String inventario(Model model) {
		model.addAttribute("modulo", "INVENTARIO");
		return "/inventario/home";
	}
	
	@GetMapping("/seguridad")
	private String seguridad(Model model) {
		model.addAttribute("modulo", "SEGURIDAD");
		return "/seguridad/home";
	}
	
	@GetMapping("/tesoreria")
	private String tesoreria(Model model) {
		model.addAttribute("modulo", "TESORERIA");
		return "/tesoreria/home";
	}
	
	@GetMapping("/ventas")
	private String ventas(Model model) {
		model.addAttribute("modulo", "VENTAS");
		return "/ventas/home";
	}
	
}
