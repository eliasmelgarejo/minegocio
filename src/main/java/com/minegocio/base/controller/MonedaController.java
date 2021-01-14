package com.minegocio.base.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.service.MonedaService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/monedas")
public class MonedaController{
	
	@Autowired
	private MonedaService service;
	
	//Listado de monedas
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Moneda> monedaPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("monedaPage",monedaPage);
        
        int totalPages = monedaPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Monedas");

		return "base/monedas/index";
	}
	
	
	//nueva moneda
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nueva Moneda");

		return "base/monedas/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Moneda moneda) { // ⑥
		moneda.setActivo(true);
		moneda.setSimbolo(moneda.getSimbolo().toUpperCase());
		moneda.setBase(true);
		service.create(moneda);
		return "redirect:/base/monedas";
	}
	
	
	
	//ver datos de moneda
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Moneda");
		Moneda moneda = service.findById(id);
		model.addAttribute("moneda", moneda);
		return "base/monedas/show";
	}
	
}