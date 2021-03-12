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

import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.PaisService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/paises")
public class PaisController implements IController<Pais>{

	@Autowired
	private PaisService service;
	
	//Listado de paises
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Pais> entityPage = service.findPaginated(currentPage-1, size);
       
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
		model.addAttribute("titulo_listado","Lista Paises");
		
		return "base/paises/index";
	}
	
	
	//Crear Nuevo pais
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo País");
		
		return "base/paises/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Pais pais) {
		pais.setActivo(true);
		pais.setNombre(pais.getNombre().toUpperCase());
		pais.setGentilicio(pais.getGentilicio().toUpperCase());
		service.create(pais);
		return "redirect:/base/paises";
	}

	
	//Ver pais
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos País");
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "base/paises/show";
	}
	
	
	//Editar pais
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Datos");
		
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		
		return "base/paises/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Pais pais) {
		pais.setId(id);
		service.update(pais);
		
		return "redirect:/base/paises";
	}

	
	//Eliminar pais
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/paises";
	}
	
	
}
