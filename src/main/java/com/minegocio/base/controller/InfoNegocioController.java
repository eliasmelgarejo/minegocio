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
import com.minegocio.base.domain.InfoNegocio;
import com.minegocio.base.service.InfoNegocioService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/infonegocio")
public class InfoNegocioController {

	@Autowired
	private InfoNegocioService service;

	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<InfoNegocio> entityPage = service.findPaginated(currentPage-1, pageSize);
        
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
		model.addAttribute("titulo_listado","Listado de InfoNegocio");
		
		return "base/infonegocio/index";
	}
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear InfoNegocio");
		
		return "base/infonegocio/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute InfoNegocio infonegocio) { // ⑥
		if(infonegocio!=null) {
			System.out.println("Contacto: "+infonegocio.getContacto());
		}
		infonegocio.setActivo(true);
		infonegocio.setNombre(infonegocio.getNombre().toUpperCase());
		service.create(infonegocio);			
//		try {
//		} catch (Exception e) {
//			System.err.println("Error: "+e.getMessage());
//		}
		
		return "redirect:/base/infonegocio"; // ⑦
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de InfoNegocio");
		InfoNegocio infonegocio = service.findById(id);
		model.addAttribute("infonegocio", infonegocio);
		
		return "base/infonegocio/show";
	}
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar InfoNegocio");
		InfoNegocio infonegocio = service.findById(id);
		model.addAttribute("infonegocio", infonegocio);

		return "base/infonegocio/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute InfoNegocio infonegocio) {
		infonegocio.setId(id);
		service.update(infonegocio);
		return "redirect:/base/infonegocio";
	}
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/infonegocio";
	}

}
