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

import com.minegocio.base.domain.Sucursal;
import com.minegocio.base.service.SucursalService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;
import com.minegocio.inventario.domain.Deposito;
import com.minegocio.inventario.service.DepositoService;

@Controller
@RequestMapping("/inventario/depositos")
public class DepositoController implements IController<Deposito> {

	@Autowired
	private DepositoService service;
	@Autowired
	private SucursalService sucursalService;
	
	//Listado de depositos
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Deposito> entityPage = service.findPaginated(currentPage-1, size);
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
		model.addAttribute("titulo_listado","Lista Depositos");
		
		return "inventario/depositos/index";
	}
	
	
	//Crear Nuevo deposito
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Deposito");
		model.addAttribute("lista_sucursales", sucursalService.findAll());
		return "inventario/depositos/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Deposito deposito) {
		deposito.setActivo(true);
		deposito.setNombre(deposito.getNombre().toUpperCase());
		Sucursal s = sucursalService.findByDireccion(deposito.getSucursal().getDireccion());
		deposito.setSucursal(s);
		service.create(deposito);
		return "redirect:/inventario/depositos";
	}
	
	
	
	//ver deposito
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Datos Deposito");
		Deposito deposito= service.findById(id);
		model.addAttribute("deposito", deposito);
		return "inventario/depositos/show";
	}
	
	
	//Editar deposito
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
	
	
	//Eliminar deposito
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/inventario/depositos";
	}
	
}
