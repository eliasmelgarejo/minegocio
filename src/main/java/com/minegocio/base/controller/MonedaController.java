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

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.service.MonedaService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/monedas")
public class MonedaController implements IController<Moneda> {

	@Autowired
	private MonedaService service;
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Moneda> entityPage = service.findPaginated(currentPage-1, pageSize);
        
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
		model.addAttribute("titulo_listado","Listado de Monedas");
		
		return "base/monedas/index";
	}
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Moneda");
		
		return "base/monedas/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Moneda moneda) { // ⑥
		moneda.setActivo(true);
		service.create(moneda);
		
		return "redirect:/base/monedas"; // ⑦
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Moneda");
		Moneda moneda = service.findById(id);
		model.addAttribute("moneda", moneda);
		
		return "base/monedas/show";
	}
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Moneda");
		Moneda moneda = service.findById(id);
		model.addAttribute("moneda", moneda);

		return "base/monedas/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Moneda moneda) {
		moneda.setId(id);
		service.update(moneda);
		return "redirect:/base/monedas";
	}
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/monedas";
	}

}
