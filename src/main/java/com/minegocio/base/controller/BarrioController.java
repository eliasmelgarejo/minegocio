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

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.service.BarrioService;
import com.minegocio.base.service.CiudadService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/barrios")
public class BarrioController implements IController<Barrio>{
	
	@Autowired
	private BarrioService service;
	@Autowired
	private CiudadService ciudadService;
	
	//Listado de barrios
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Barrio> entityPage = service.findPaginated(currentPage-1, pageSize);
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
		model.addAttribute("titulo_listado","Lista Barrios");
		
		return "base/barrios/index";
	}
	
	
	//Crear Nuevo barrio
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Barrio");
		model.addAttribute("lista_ciudades", ciudadService.findAll());
		return "base/barrios/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Barrio barrio) {
		barrio.setActivo(true);
		barrio.setNombre(barrio.getNombre().toUpperCase());
		Ciudad c = ciudadService.findByNombre(barrio.getCiudad().getNombre());
		barrio.setCiudad(c);
		service.create(barrio);
		
		return "redirect:/base/barrios";
	}
	
	
	//Ver barrio
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos Barrio");
	
		Barrio barrio = service.findById(id);
		model.addAttribute("barrio", barrio);
		
		return "base/barrios/show";
	}
	
	
	//Editar barrio
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Datos");
	
		Barrio barrio = service.findById(id);
		model.addAttribute("lista_ciudades", ciudadService.findAll());
		model.addAttribute("barrio", barrio);

		return "base/barrios/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Barrio barrio) {
		//ME FALTA PONER POR DEFAULT LA CIUDAD QUE ESTA REGISTRADO CON EL BARRIO.
		Ciudad c = ciudadService.findByNombre(barrio.getCiudad().getNombre());
		barrio.setCiudad(c);
		barrio.setId(id);
		service.update(barrio);
		
		return "redirect:/base/barrios";
	}
	
	
	//Eliminar barrio
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/barrios";
	}
	
}
