package com.minegocio.inventario.controller;


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

import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;
import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.service.MarcaService;

@Controller
@RequestMapping("/inventario/marcas")
public class MarcaController implements IController<Marca>{

	@Autowired
	private MarcaService service;
	
	
	//Listado de marcas
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Marca> entityPage = service.findPaginated(currentPage-1, size);
        model.addAttribute("entityPage", entityPage);
        
        int totalPages = entityPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_listado","Lista Marcas");

		return "inventario/marcas/index";
	}
	
	
	//Crear Nueva marca
	@GetMapping("new") 
	public String create(Model model) {
		model.addAttribute("modulo"," "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Crear Nueva Marca"); 
		return "inventario/marcas/new"; 
	 }
	 
	@PostMapping("create") 
	public String create(@ModelAttribute Marca marca) {
		marca.setActivo(true); 
		marca.setNombre(marca.getNombre().toUpperCase()); 
		service.create(marca);
		return "redirect:/inventario/marcas";
	}
	 

	//Ver marca
	@GetMapping("{id}") 
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo"," "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Datos Marca"); 
		 
		Marca marca = service.findById(id); 
		model.addAttribute("marca", marca); 
		return "inventario/marcas/show";	  
	}
	 
	
	//Editar marca
	@GetMapping("edit={id}") 
	public String edit(@PathVariable Long id, Model model) {  
		model.addAttribute("modulo"," "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Marca"); 
		Marca marca= service.findById(id); 
		model.addAttribute("marca", marca);
		  
		return "inventario/marcas/edit"; 
	}
	 
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Marca marca) {
		marca.setId(id);
		service.update(marca);
		return "redirect:/inventario/marcas";
	}
	
	
	//Eliminar marca
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/inventario/marcas";
	}
	
}
