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
//import com.minegocio.base.domain.Barrio;
//import com.minegocio.base.service.BarrioService;
//import com.minegocio.config.ConfigModulosMenus;
//import com.minegocio.core.IController;
//
//@Controller
//@RequestMapping("/base/barrios")
//public class BarrioController implements IController{
//
//	@Autowired
//	private BarrioService service;
//	
//	@Override
//	@GetMapping
//	public String index(Model model) {
//		List<Barrio> lista = service.findAll();
//		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
//		model.addAttribute("menus", ConfigModulosMenus.base().menus);
//		model.addAttribute("titulo_listado","Listado de Barrios");
//		model.addAttribute("lista", lista);
//		return "/base/barrios/index";
//	}
//
//	@Override
//	@GetMapping("new")
//	public String create(Model model) {
//		return "/base/barrios/new";
//	}
//	
//	@Override
//	@PostMapping
//	public String create(@ModelAttribute Object barrio) { // ⑥
//		service.save((Barrio)barrio);
//		return "redirect:/base/barrios"; // ⑦
//	}
//
//	@Override
//	@GetMapping("{id}/edit")
//	public String edit(@PathVariable Long id, Model model) { //
//		Barrio barrio = service.findById(id);
//		model.addAttribute("barrio", barrio);
//		return "base/barrios/edit";
//	}
//
//	@Override
//	@GetMapping("{id}")
//	public String show(@PathVariable Long id, Model model) {
//		Barrio barrio = service.findById(id);
//		model.addAttribute("barrio", barrio);
//		return "base/barrios/show";
//	}
//	
//	@Override
//	@PutMapping("{id}")
//	public String update(@PathVariable Long id, @ModelAttribute Object barrio) {
//		((Barrio) barrio).setId(id);
//		service.save((Barrio)barrio);
//		return "redirect:/base/barrios";
//	}
//
//	@Override
//	@DeleteMapping("{id}")
//	public String destroy(@PathVariable Long id) {
//		service.delete(id);
//		return "redirect:/base/barrios";
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

import com.minegocio.base.domain.Barrio;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.BarrioService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/barrios")
public class BarrioController{
	
	@Autowired
	private BarrioService service;
	
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Barrio> barrioPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("barrioPage",barrioPage);
        
        int totalPages = barrioPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        

		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Barrios");
		
		return "base/barrios/index";
	}
	
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Barrio");
		return "base/barrios/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Barrio barrio) {
		barrio.setActivo(true);
		barrio.setNombre(barrio.getNombre().toUpperCase());
		service.create(barrio);
		
		return "redirect:/base/barrios";
	}
	
	
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Barrio");
		
		Barrio barrio = service.findById(id);
		model.addAttribute("barrio", barrio);
		
		return "base/barrios/show";
	}
	
	
	
	
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Barrio");
		Barrio barrio = service.findById(id);
		model.addAttribute("barrio", barrio);

		return "base/barrios/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Barrio barrio) {
		barrio.setId(id);
		service.update(barrio);
		
		return "redirect:/base/barrios";
	}
	
	
	//NO FUNCIONA
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/barrios";
	}
	
	
}

