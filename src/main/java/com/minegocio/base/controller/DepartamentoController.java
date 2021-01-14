package com.minegocio.base.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.service.DepartamentoService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/departamentos")
public class DepartamentoController{
	
	@Autowired
	private DepartamentoService service;
	
	//listado de departamentos
	@GetMapping
	public String index(Model model, 
						@RequestParam(defaultValue="1") int page, 
						@RequestParam(defaultValue="1") int size ) {
		
		int currentPage = page;
		int pageSize = size;
		Page<Departamento> departamentoPage = service.findPaginated(currentPage-1, size);
		
		model.addAttribute("departamentoPage", departamentoPage);
		
		int totalPages = departamentoPage.getTotalPages();
		
		if(totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                .boxed()
	                .collect(Collectors.toList());
	        model.addAttribute("pageNumbers", pageNumbers);
		}
		
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Departamentos");
		
		return "base/departamentos/index";
	}
	
	
	//crear nuevo departamento
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Departamento");
		return "base/departamentos/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Departamento departamento) {
		departamento.setActivo(true);
		departamento.setNombre(departamento.getNombre().toUpperCase());
		service.create(departamento);
		return "redirect:/base/departamentos";
	}
	
	
	//ver departamento
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Departamento");
		Departamento departamento = service.findById(id);
		model.addAttribute("departamento", departamento);
		return "base/departamentos/show";
	}
	
	
	//editar departamento
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Departamento");
		Departamento departamento = service.findById(id);
		model.addAttribute("departamento", departamento);
		return "base/departamentos/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Departamento departamento) {
		departamento.setId(id);
		service.update(departamento);
		return "redirect:/base/departamentos";
	}

	
	
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/departamentos";
	}
	
}
