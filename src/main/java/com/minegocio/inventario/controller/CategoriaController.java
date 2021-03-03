package com.minegocio.inventario.controller;

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

import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;
import com.minegocio.inventario.domain.Categoria;
import com.minegocio.inventario.service.CategoriaService;

@Controller
@RequestMapping("/inventario/categorias")
public class CategoriaController implements IController<Categoria>{
	
	@Autowired
	private CategoriaService service;
	
	//Listado de categorias
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Categoria> entityPage = service.findPaginated(currentPage-1, size);
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
		model.addAttribute("titulo_listado","Lista Categorias");
		
		return "inventario/categorias/index";
	}
	
	
	//Crear Nueva categoria
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Crear Nueva Categoria");
		return "inventario/categorias/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Categoria categoria) {
		categoria.setActivo(true);
		categoria.setNombre(categoria.getNombre().toUpperCase());
		categoria.setImage(categoria.getImage());
		service.create(categoria);
		return "redirect:/inventario/categorias";
	}
	
	
	//Ver categoria
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		System.out.println("ENTRO ACA");
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Datos Categoria");
		Categoria categoria = service.findById(id);
		model.addAttribute("categoria", categoria);
		return "inventario/categorias/show";
	}
	
	
	//Editar categoria
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Categoria");
		Categoria categoria = service.findById(id);
		model.addAttribute("categoria", categoria);
		return "inventario/categorias/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Categoria categoria) {
		categoria.setId(id);
		service.update(categoria);
		return "redirect:/inventario/categorias";
	}
	
	
	//Eliminar categoria
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/inventario/categorias";
	}
	
}
