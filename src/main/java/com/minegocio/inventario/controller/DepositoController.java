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
import com.minegocio.inventario.domain.Deposito;
import com.minegocio.inventario.service.DepositoService;

@Controller
@RequestMapping("/inventario/depositos")
public class DepositoController {

	@Autowired
	private DepositoService service;
	
	//Listado de Depositos
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Deposito> depositoPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("depositoPage",depositoPage);
        
        int totalPages = depositoPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_listado","Listado de Depositos");
		
		return "inventario/depositos/index";
	}
	
	
	//nuevo deposito
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Deposito");
		return "inventario/depositos/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Deposito deposito) {
		deposito.setActivo(true);
		deposito.setNombre(deposito.getNombre().toUpperCase());
		service.create(deposito);
		return "redirect:/inventario/depositos";
	}
	
	
	
	//ver datos de deposito
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Datos de Deposito");
		Deposito deposito= service.findById(id);
		model.addAttribute("deposito", deposito);
		return "inventario/depositos/show";
	}
	
	
	//editar deposito
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Deposito");
		Deposito deposito = service.findById(id);
		model.addAttribute("deposito", deposito);
		return "inventario/depositos/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Deposito deposito) {
		deposito.setId(id);
		service.update(deposito);
		return "redirect:/inventario/depositos";
	}
	
	
	//
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/inventario/depositos";
	}
	
}
