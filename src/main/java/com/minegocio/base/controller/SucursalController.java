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

import com.minegocio.base.domain.Sucursal;
import com.minegocio.base.service.SucursalService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/sucursales")
public class SucursalController implements IController {

	@Autowired
	private SucursalService service;
	
	@Override
	@GetMapping
	public String index(Model model) {
		List<Sucursal> lista = service.findAll();
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Sucursales");
		model.addAttribute("lista", lista);
		return "/base/sucursales/index";
	}

	@Override
	@GetMapping("new")
	public String create(Model model) {
		return "base/sucursales/new";
	}
	
	@Override
	@PostMapping
	public String create(@ModelAttribute Object entity) { // ⑥
		service.save((Sucursal)entity);
		return "redirect:/base/sucursales"; // ⑦
	}

	@Override
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) { //
		Sucursal entity = service.findById(id);
		model.addAttribute("entity", entity);
		return "base/sucursales/edit";
	}

	@Override
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Sucursal entity = service.findById(id);
		model.addAttribute("entity", entity);
		return "base/sucursales/show";
	}
	
	@Override
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Object entity) {
		((Sucursal) entity).setId(id);
		service.save((Sucursal)entity);
		return "redirect:/base/sucursales";
	}

	@Override
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/base/sucursales";
	}
}
