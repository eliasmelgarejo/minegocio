//package com.minegocio.base.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.minegocio.base.domain.Ciudad;
//import com.minegocio.base.service.CiudadService;
//import com.minegocio.config.ConfigModulosMenus;
//import com.minegocio.core.IController;
//
//@Controller
//@RequestMapping("/base/ciudades")
//public class CiudadController implements IController{
//
//	@Autowired
//	private CiudadService service;
//	
//	@Override
//	@GetMapping
//	public String index(Model model) {
//		List<Ciudad> lista = service.findAll();
//		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
//		model.addAttribute("menus", ConfigModulosMenus.base().menus);
//		model.addAttribute("titulo_listado","Listado de Ciudades");
//		model.addAttribute("lista", lista);
//		return "/base/ciudades/index";
//	}
//
//	@Override
//	@GetMapping("new")
//	public String create(Model model) {
//		return "base/ciudades/new";
//	}
//	
//	@Override
//	@PostMapping
//	public String create(@ModelAttribute Object ciudad) { // ⑥
//		service.save((Ciudad)ciudad);
//		return "redirect:/base/ciudades"; // ⑦
//	}
//
//	@Override
//	@GetMapping("{id}/edit")
//	public String edit(@PathVariable Long id, Model model) { //
//		Ciudad ciudad = service.findById(id);
//		model.addAttribute("ciudad", ciudad);
//		return "base/ciudades/edit";
//	}
//
//	@Override
//	@GetMapping("{id}")
//	public String show(@PathVariable Long id, Model model) {
//		Ciudad ciudad = service.findById(id);
//		model.addAttribute("ciudad", ciudad);
//		return "base/ciudades/show";
//	}
//	
//	@Override
//	@PutMapping("{id}")
//	public String update(@PathVariable Long id, @ModelAttribute Object ciudad) {
//		((Ciudad) ciudad).setId(id);
//		service.save((Ciudad)ciudad);
//		return "redirect:/base/ciudades";
//	}
//
//	@Override
//	@DeleteMapping("{id}")
//	public String destroy(@PathVariable Long id) {
//		service.delete(id);
//		return "redirect:/base/ciudades";
//	}	
//
//
//}





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

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.CiudadService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/ciudades")
public class CiudadController{
	
	@Autowired
	private CiudadService service;
	
	//lista
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Ciudad> ciudadPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("ciudadPage",ciudadPage);
        
        int totalPages = ciudadPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Ciudades");
		
		return "base/ciudades/index";
	}
	
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo", "Crear Ciudad");
		
		return "base/ciudades/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Ciudad ciudad) {
		ciudad.setActivo(true);
		ciudad.setNombre(ciudad.getNombre().toUpperCase());
		service.create(ciudad);
		return "redirect:/base/ciudades";
	}
	
	
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Ciudad");
		
		Ciudad ciudad = service.findById(id);

		model.addAttribute("ciudad", ciudad);
		
		return "base/ciudades/show";
	}
	
	
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Ciudad");
		
		Ciudad ciudad = service.findById(id);
		
		model.addAttribute("ciudad", ciudad);
		return "base/ciudades/edit";
	}
	
	
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Ciudad ciudad) {
		ciudad.setId(id);
		service.update(ciudad);
		
		return "redirect:/base/ciudades";
	}
	
	
	//NO FUNCIONA, NO ELIMINA EL REGISTRO, NO PASA NADA EN LA PANTALLA.
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/ciudades";
	}
	
}
	