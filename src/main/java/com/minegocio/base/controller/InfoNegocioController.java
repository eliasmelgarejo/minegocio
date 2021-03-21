package com.minegocio.base.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.minegocio.base.domain.InfoNegocio;
import com.minegocio.base.service.InfoNegocioService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/infonegocios")
public class InfoNegocioController implements IController<InfoNegocio>{

	@Autowired
	private InfoNegocioService service;
	

	//Listado de infonegocios
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<InfoNegocio> entityPage = service.findPaginated(currentPage-1, size);
        model.addAttribute("entityPage", entityPage);
        
        int totalPages = entityPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Lista Negocios");
		
		return "base/infonegocios/index";
	}
	
	
	//Crear Nuevo InfoNegocio
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Negocio");
		
		return "base/infonegocios/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute InfoNegocio infoNegocio) {
		infoNegocio.setActivo(true);
		infoNegocio.setNombre(infoNegocio.getNombre().toUpperCase());
		infoNegocio.setTelefono(infoNegocio.getTelefono());
		infoNegocio.setEmail(infoNegocio.getEmail());
		infoNegocio.setContacto(infoNegocio.getContacto());
		
		service.create(infoNegocio);
		return "redirect:/base/infonegocios";
	}

	
	//Ver InfoNegocio
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos Negocio");
		
		InfoNegocio infoNegocio = service.findById(id);
		model.addAttribute("infoNegocio", infoNegocio);
		
		return "base/infonegocios/show";
	}
	
	
	//Editar InfoNegocio
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Datos");
		
		InfoNegocio infoNegocio = service.findById(id);
		model.addAttribute("infoNegocio", infoNegocio);
		
		return "base/infonegocios/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute InfoNegocio infoNegocio) {
		infoNegocio.setId(id);
		service.update(infoNegocio);
		
		return "redirect:/base/infonegocios";
	}

	
	//Eliminar InfoNegocio
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
		InfoNegocio entity = service.findById(id);
		boolean result = service.delete(entity); 
		return "redirect:/base/infonegocios";
	}
	
	
}
