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
