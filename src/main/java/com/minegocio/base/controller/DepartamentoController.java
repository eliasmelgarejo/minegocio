//package com.minegocio.base.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.minegocio.base.domain.Departamento;
//import com.minegocio.base.service.DepartamentoService;
//import com.minegocio.config.ConfigModulosMenus;
//import com.minegocio.core.IController;
//
//@Controller
//@RequestMapping("/base/departamentos")
//public class DepartamentoController implements IController{
//
//	@Autowired
//	private DepartamentoService service;
//	
//	@Override
//	@GetMapping
//	public String index(Model model) {
//		List<Departamento> lista = service.findAll();
//		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
//		model.addAttribute("menus", ConfigModulosMenus.base().menus);
//		model.addAttribute("titulo_listado","Listado de Departamentos");
//		model.addAttribute("lista", lista);
//		return "/base/departamentos/index";
//	}
//
//	@Override
//	@GetMapping("new")
//	public String create(Model model) {
//		return "base/departamentos/new";
//	}
//	
//	@Override
//	@PostMapping
//	public String create(@ModelAttribute Object departamento) { // ⑥
//		service.save((Departamento)departamento);
//		return "redirect:/base/departamentos"; // ⑦
//	}
//
//	@Override
//	@GetMapping("{id}/edit")
//	public String edit(@PathVariable Long id, Model model) { //
//		Departamento departamento = service.findById(id);
//		model.addAttribute("departamento", departamento);
//		return "base/departamentos/edit";
//	}
//
//	@Override
//	@GetMapping("{id}")
//	public String show(@PathVariable Long id, Model model) {
//		Departamento departamento = service.findById(id);
//		model.addAttribute("departamento", departamento);
//		return "base/departamentos/show";
//	}
//	
//	@Override
//	@PutMapping("{id}")
//	public String update(@PathVariable Long id, @ModelAttribute Object departamento) {
//		((Departamento) departamento).setId(id);
//		service.save((Departamento)departamento);
//		return "redirect:/base/departamentos";
//	}
//
//	@Override
//	@DeleteMapping("{id}")
//	public String destroy(@PathVariable Long id) {
//		service.delete(id);
//		return "redirect:/base/departamentos";
//	}	
//
//
//}



//************************************************//

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
import com.minegocio.base.service.dto.DepartamentoDto;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/departamentos")

public class DepartamentoController{
	
	@Autowired
	private DepartamentoService service;
	
	
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
	
	
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Departamento");
		return "base/departamentos/new";
	}
	
	
	
	
	
}


