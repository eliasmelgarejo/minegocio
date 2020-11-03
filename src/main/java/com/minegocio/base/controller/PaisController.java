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

import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.PaisService;
import com.minegocio.base.service.dto.PaisDto;

@Controller
@RequestMapping("/base/pais")
public class PaisController {

	@Autowired
	PaisService service;

	@GetMapping
	public String index(Model model) {
		List<Pais> lista = service.findAll();
		model.addAttribute("lista", lista);
		return "/base/pais/index";
	}

	@GetMapping("new")
	public String create(Model model) {
		return "base/pais/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) { //
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "base/pais/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "base/pais/show";
	}

	@PostMapping
	public String create(@ModelAttribute PaisDto dto) { // ⑥
		//service.save(pais);
		service.create(service.convertToEntity(dto));
		return "redirect:/base/pais"; // ⑦
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute PaisDto pais) {
		pais.setId(id);
		service.update(service.convertToEntity(pais));
		return "redirect:/base/pais";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/pais";
	}
}
