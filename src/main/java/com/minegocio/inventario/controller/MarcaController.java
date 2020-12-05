package com.minegocio.inventario.controller;

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

import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.service.MarcaService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/inventario/marca")
public class MarcaController {

	@Autowired
	private MarcaService service;

	@GetMapping
	public String index(Model model) {
		List<Marca> lista = service.findAll();
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_listado","Listado de Marcas");
		model.addAttribute("marcas", lista);
		return "/inventario/marcas/index";/*aca me puede dar error,dejar que salga*/
	}

	@GetMapping("new")
	public String create(Model model) {
		return "base/infonegocio/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) { //
		Marca marca = service.findById(id);
		model.addAttribute("marca", marca);
		return "inventario/marca/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Marca marca = service.findById(id);
		model.addAttribute("marca", marca);
		return "inventario/marca/show";
	}

	@PostMapping
	public String create(@ModelAttribute Marca marca) { // ⑥
		service.save(marca);
		return "redirect:/inventario/marca"; // ⑦
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Marca marca) {
		marca.setId(id);
		service.save(marca);
		return "redirect:/inventario/marca";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/inventario/marca";
	}
}
