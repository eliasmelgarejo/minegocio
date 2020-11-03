package com.minegocio.home.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<MenuDTO> menus = new ArrayList<>();
		
		MenuDTO negocio = new MenuDTO();
		negocio.menu="Negocio";
		menus.add(negocio);
		
		MenuDTO sucursal = new MenuDTO();
		sucursal.menu="Sucursal";
		menus.add(sucursal);
		
		MenuDTO empleado = new MenuDTO();
		empleado.menu="Empleado";
		menus.add(empleado);
		
		MenuDTO pais = new MenuDTO();
		pais.menu="Pais";
		menus.add(pais);
		
		MenuDTO departamento = new MenuDTO();
		departamento.menu="Departamento";
		menus.add(departamento);
		
		MenuDTO ciudad = new MenuDTO();
		ciudad.menu="Departamento";
		menus.add(ciudad);
		
		MenuDTO barrio = new MenuDTO();
		barrio.menu="Barrio";
		menus.add(barrio);
		
		model.addAttribute("menus", menus);
		
		return "/base/home";
	}
	
	@GetMapping("/compras")
	private String compras(Model model) {
		model.addAttribute("modulo", "COMPRAS");
		return "/compras/home";
	}
	
	@GetMapping("/inventario")
	private String inventario(Model model) {
		List<MenuDTO> menus = new ArrayList<>();
		
		MenuDTO marca = new MenuDTO();
		marca.menu="MARCAS";
		marca.URL="/base/marcas";
		menus.add(marca);
		
		MenuDTO categoria = new MenuDTO();
		categoria.menu="CATEGORIAS";
		categoria.URL="/base/categorias";
		menus.add(categoria);
				
		model.addAttribute("modulo", " INVENTARIO");
		model.addAttribute("menus",menus);
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
