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
import com.minegocio.base.domain.InfoNegocio;
import com.minegocio.base.domain.Sucursal;
import com.minegocio.base.service.BarrioService;
import com.minegocio.base.service.CiudadService;
import com.minegocio.base.service.InfoNegocioService;
import com.minegocio.base.service.SucursalService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/sucursales")
public class SucursalController implements IController<Sucursal> {
	
	@Autowired
	private SucursalService service;
	@Autowired
	private InfoNegocioService infonegocioService;
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private BarrioService barrioService;
	
	//Listado de sucursales
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        //Page<Sucursal> sucursalPage = service.findPaginated(currentPage-1, size);
        //model.addAttribute("sucursalPage", sucursalPage);
        Page<Sucursal> entityPage = service.findPaginated(currentPage-1, size);
        model.addAttribute("entityPage", entityPage);
        
        //int totalPages = sucursalPage.getTotalPages();
        int totalPages = entityPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Lista Sucursales");
		
		return "base/sucursales/index";
	}
	
	
	//HASTA ACA LLEGUE NO FUNCION LA PARTE DE INSERTAR DATOS
	//Crear Nueva sucursal
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nueva Sucursal");
		model.addAttribute("lista_infonegocios", infonegocioService.findAll());
		model.addAttribute("lista_ciudades", ciudadService.findAll());
		model.addAttribute("lista_barrios", barrioService.findAll());
		return "base/sucursales/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Sucursal sucursal) {
		sucursal.setActivo(true);
		sucursal.setDireccion(sucursal.getDireccion());
		Ciudad c = ciudadService.findByNombre(sucursal.getCiudad().getNombre());
		sucursal.setCiudad(c);
		Barrio b = barrioService.findByNombre(sucursal.getBarrio().getNombre());
		sucursal.setBarrio(b);
		
		InfoNegocio i = infonegocioService.findByNombre(sucursal.getNegocio().getNombre());
		sucursal.setNegocio(i);
		
		service.create(sucursal);
		return "redirect:/base/sucursales";
	}
	
	
	
	//ver datos de sucursal especifica.
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Sucursal");
		Sucursal sucursal = service.findById(id);
		model.addAttribute("sucursal", sucursal);
		return "base/sucursales/show";
	}
	
	
	
	//editar sucursal
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Sucursal");
		Sucursal sucursal = service.findById(id);
		model.addAttribute("sucursal", sucursal);
		return "base/sucursales/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Sucursal sucursal) {
		sucursal.setId(id);
		service.update(sucursal);
		return "redirect:/base/sucursales";
	}

	
	//eliminar sucursal
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/sucursales";
	}
	
}