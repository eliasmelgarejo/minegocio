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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.DepartamentoService;
import com.minegocio.base.service.PaisService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/departamentos")
public class DepartamentoController implements IController<Departamento>{
	
	@Autowired
	private DepartamentoService service;
	@Autowired
	private PaisService paisService;
	
	//Listado de departamentos
	@GetMapping
	public String index(Model model, 
						@RequestParam(defaultValue="1") int page, 
						@RequestParam(defaultValue="1") int size ) {
		
		int currentPage = page;
		int pageSize = size;
		Page<Departamento> entityPage = service.findPaginated(currentPage-1, pageSize);
		model.addAttribute("entityPage",entityPage);
		
		int totalPages = entityPage.getTotalPages();
		if(totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                .boxed()
	                .collect(Collectors.toList());
	        model.addAttribute("pageNumbers", pageNumbers);
		}
		
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Lista Departamentos");
		
		return "base/departamentos/index";
	}
	
	
	//Crear Nuevo departamento
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Departamento");
		model.addAttribute("lista_paises", paisService.findAll());
		return "base/departamentos/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Departamento departamento) {
		departamento.setActivo(true);
		departamento.setNombre(departamento.getNombre().toUpperCase());
		Pais p = paisService.findByNombre(departamento.getPais().getNombre());
		departamento.setPais(p);
		service.create(departamento);
		return "redirect:/base/departamentos";
	}
	
	
	//Ver departamento
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos Departamento");
		Departamento departamento = service.findById(id);
		model.addAttribute("departamento", departamento);
		return "base/departamentos/show";
	}
	
	
	//Editar departamento
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Datos");
		Departamento departamento = service.findById(id);
		model.addAttribute("lista_paises", paisService.findAll());
		model.addAttribute("departamento", departamento);
		
		return "base/departamentos/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Departamento departamento) {
		//ME FALTA PONER POR DEFAULT EL PAIS QUE ESTA REGISTRADO CON EL DEPARTAMENTO.
		Pais p = paisService.findByNombre(departamento.getPais().getNombre());
		departamento.setPais(p);
		
		departamento.setId(id);
		
		service.update(departamento);
		return "redirect:/base/departamentos";
	}

	
	//Eliminar departamento
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/departamentos";
	}
	
}
