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

import com.minegocio.base.domain.InfoNegocio;
import com.minegocio.base.service.InfoNegocioService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/infonegocio")
public class InfoNegocioController {

	@Autowired
	private InfoNegocioService service;

	@GetMapping
	public String index(Model model) {
		List<InfoNegocio> lista = service.findAll();
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Negocios");
		model.addAttribute("infoNegocios", lista);
		return "/base/infonegocio/index";
	}

	@GetMapping("new")
	public String create(Model model) {
		return "base/infonegocio/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) { //
		InfoNegocio info = service.findById(id);
		model.addAttribute("info", info);
		return "base/infonegocio/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		InfoNegocio info = service.findById(id);
		model.addAttribute("info", info);
		return "base/infonegocio/show";
	}

	@PostMapping
	public String create(@ModelAttribute InfoNegocio info) { // ⑥
		service.save(info);
		return "redirect:/base/infonegocio"; // ⑦
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute InfoNegocio info) {
		info.setId(id);
		service.save(info);
		return "redirect:/base/infonegocio";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/base/infonegocio";
	}
}
