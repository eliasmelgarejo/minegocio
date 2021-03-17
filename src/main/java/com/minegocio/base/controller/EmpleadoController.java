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

import com.minegocio.base.domain.Empleado;
import com.minegocio.base.service.BarrioService;
import com.minegocio.base.service.CiudadService;
import com.minegocio.base.service.EmpleadoService;
import com.minegocio.base.service.PersonaService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/empleados")
public class EmpleadoController implements IController<Empleado>{
	//HASTA AQUI LLEGUE, HICE EL FORM INDEX Y NEW ME FALTA SHOW Y EDIT Y TAMBIEN
	//TODA LA PROGRAMACION PARA EL NEW,SHOW,EDIT AQUI EN EL CONTROLLER

	@Autowired
	private EmpleadoService service;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private BarrioService barrioService;
	
	//Listado de empleados
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Empleado> entityPage = service.findPaginated(currentPage-1, size);
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
		model.addAttribute("titulo_listado","Lista Empleados");
		
		return "base/empleados/index";
	}
	
	
	//Crear Nuevo empleado
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Empleado");
		
		model.addAttribute("lista_ciudades", ciudadService.findAll());
		model.addAttribute("lista_barrios", barrioService.findAll());
		
		return "base/empleados/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Empleado empleado) {
		empleado.setActivo(true);
		//empleado.setNombre(empleado.getNombre().toUpperCase());
		//empleado.setGentilicio(empleado.getGentilicio().toUpperCase());
		service.create(empleado);
		return "redirect:/base/empleados";
	}

	
	//Ver empleado
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos País");
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado", empleado);
		return "base/empleados/show";
	}
	
	
	//Editar empleado
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Datos");
		
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado", empleado);
		
		return "base/empleados/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Empleado empleado) {
		empleado.setId(id);
		service.update(empleado);
		
		return "redirect:/base/empleados";
	}

	
	//Eliminar empleado
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/empleados";
	}
	
	
}
