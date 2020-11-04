package com.minegocio.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	private String layout() {
		return "plantillas/layout";
	}
	
	@GetMapping("/listado")
	private String plantilla_listado() {
		return "plantillas/plantilla_listado";
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
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		
		return "/base/home";
	}
	
	@GetMapping("/compras")
	private String compras(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.compras().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.compras().menus);
		
		return "/compras/home";
	}
	
	@GetMapping("/ventas")
	private String ventas(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.ventas().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.ventas().menus);
		
		return "/ventas/home";
	}
	
	@GetMapping("/inventario")
	private String inventario(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		
		return "/inventario/home";
	}
	
	@GetMapping("/tesoreria")
	private String tesoreria(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.tesoreria().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.tesoreria().menus);
		
		return "/tesoreria/home";
	}

	@GetMapping("/seguridad")
	private String seguridad(Model model) {
		model.addAttribute("modulo", " SEGURIDAD");
		return "/seguridad/home";
	}
	
	
}
