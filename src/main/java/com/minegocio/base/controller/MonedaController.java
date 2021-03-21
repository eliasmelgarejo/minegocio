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
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.MonedaService;
import com.minegocio.base.service.PaisService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/monedas")
public class MonedaController implements IController<Moneda>{
	
	@Autowired
	private MonedaService service;
	
	@Autowired
	private PaisService paisService;
	
	//Listado de monedas
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Moneda> entityPage = service.findPaginated(currentPage-1, size);
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
		model.addAttribute("titulo_listado","Lista Monedas");

		return "base/monedas/index";
	}
	
	
	//Crear Nueva moneda
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nueva Moneda");
		
		model.addAttribute("lista_paises", paisService.findAll());
		
		return "base/monedas/new";
	}
		
	@PostMapping("create")
	public String create(@ModelAttribute Moneda moneda) {
		moneda.setActivo(true);
		moneda.setSimbolo(moneda.getSimbolo().toUpperCase());
		moneda.setBase(true);
		
		Pais p = paisService.findByNombre(moneda.getPais().getNombre());
		moneda.setPais(p);
		
		service.create(moneda);
		return "redirect:/base/monedas";
	}

		
	//Ver moneda
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos Moneda");

		Moneda moneda = service.findById(id);
		model.addAttribute("moneda", moneda);
		
		return "base/monedas/show";
	}
		
		
	//Editar moneda
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Moneda");
		
		Moneda moneda = service.findById(id);
		model.addAttribute("lista_paises", paisService.findAll());
		
		model.addAttribute("moneda", moneda);
		
		return "base/monedas/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Moneda moneda) {
		//ME FALTA PONER POR DEFAULT EL PAIS QUE ESTA REGISTRADO CON LA MONEDA
		Pais p = paisService.findByNombre(moneda.getPais().getNombre());
		moneda.setPais(p);
		
		moneda.setId(id);
		service.update(moneda);
		
		return "redirect:/base/monedas";
	}

		
	//Eliminar moneda
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
		Moneda entity = service.findById(id);
		boolean result = service.delete(entity);
		return "redirect:/base/monedas";
	}
	
}