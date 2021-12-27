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

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.Departamento;
import com.minegocio.base.service.CiudadService;
import com.minegocio.base.service.DepartamentoService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/ciudades")
public class CiudadController implements IController<Ciudad>{

	@Autowired
	private CiudadService service;
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Ciudad> entityPage = service.findPaginated(currentPage-1, pageSize);
        
        model.addAttribute("entityPage",entityPage);
        
        int totalPages = entityPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Ciudades");
		
		return "/base/ciudades/index";
	}

	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Ciudad");
		model.addAttribute("lista_departamentos",departamentoService.findAll());
		
		return "/base/ciudades/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Ciudad ciudad) { // ⑥
		ciudad.setActivo(true);
		ciudad.setNombre(ciudad.getNombre().toUpperCase());
		Departamento d = departamentoService.findByNombre(ciudad.getDepartamento().getNombre());
		ciudad.setDepartamento(d);
		service.create(ciudad);
		
		return "redirect:/base/ciudades"; // ⑦
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Ciudad");
		Ciudad ciudad = service.findById(id);
		model.addAttribute("ciudad", ciudad);
		
		return "base/ciudades/show";
	}
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Ciudad");
		Ciudad ciudad = service.findById(id);
		model.addAttribute("ciudad", ciudad);
		model.addAttribute("lista_departamentos",departamentoService.findAll());
		
		return "base/ciudades/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Ciudad ciudad) {
		ciudad.setId(id);
		ciudad.setNombre(ciudad.getNombre().toUpperCase());
		Departamento d = departamentoService.findByNombre(ciudad.getDepartamento().getNombre());
		ciudad.setDepartamento(d);
		service.update(ciudad);
		
		return "redirect:/base/ciudades";
	}
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    
	    return "redirect:/base/ciudades";
	}

}
