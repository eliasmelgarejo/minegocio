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

import com.minegocio.base.domain.Persona;
import com.minegocio.base.service.PersonaService;
import com.minegocio.base.service.dto.PersonaDto;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/personas")
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	//listado de personas
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;

        Page<Persona> personaPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("personaPage", personaPage);
        
        int totalPages = personaPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Personas");
		
		return "base/personas/index";
	}
	
	
	
	//nueva persona
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nueva Persona");
		return "base/personas/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Persona persona) {
		persona.setActivo(true);
		persona.setNombres(persona.getNombres().toUpperCase());
		persona.setApellidos(persona.getApellidos().toUpperCase());
		persona.setDocumento(persona.getDocumento());
		persona.setDireccion(persona.getDireccion());
		persona.setTelefono(persona.getTelefono());
		service.create(persona);
		return "redirect:/base/personas";
	}


	
	
	
	/*
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de País");
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "base/paises/show";
	}
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar País");
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		System.out.println("##### Entro en edit Pais...");
		return "base/paises/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Pais pais) {
		System.out.println("PaisController metodo PUT...");
		pais.setId(id);
		service.update(pais);
		return "redirect:/base/paises";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/paises";
	}
	*/
}