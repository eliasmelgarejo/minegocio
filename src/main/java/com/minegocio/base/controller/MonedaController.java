package com.minegocio.base.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.service.MonedaService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/monedas")
public class MonedaController implements IController {

	@Autowired
	private MonedaService service;
	
	@Override
	@GetMapping
	public String index(Model model) {
		List<Moneda> lista = service.findAll();
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Monedas");
		model.addAttribute("lista", lista);
		return "/base/monedas/index";
	}

	@Override
	@GetMapping("new")
	public String create(Model model) {
		return "base/monedas/new";
	}
	
	@Override
	@PostMapping
	public String create(@ModelAttribute Object entity) { // ⑥
		service.save((Moneda)entity);
		return "redirect:/base/monedas"; // ⑦
	}

	@Override
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) { //
		Moneda entity = service.findById(id);
		model.addAttribute("entity", entity);
		return "base/monedas/edit";
	}

	@Override
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Moneda entity = service.findById(id);
		model.addAttribute("entity", entity);
		return "base/monedas/show";
	}
	
	@Override
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Object entity) {
		((Moneda) entity).setId(id);
		service.save((Moneda)entity);
		return "redirect:/base/monedas";
	}

	@Override
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/base/monedas";
	}
}
