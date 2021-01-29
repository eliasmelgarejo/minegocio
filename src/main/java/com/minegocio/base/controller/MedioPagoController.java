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

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.service.MedioPagoService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/mediospago")
public class MedioPagoController implements IController<MedioPago>{

	@Autowired
	private MedioPagoService service;
	
	//Listado de MediosPago
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<MedioPago> entityPage = service.findPaginated(currentPage-1, size);
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
		model.addAttribute("titulo_listado","Lista Medios Pago");

		return "base/mediospago/index";
	}
	
	
	//Crear Nuevo medioPago
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Medio de Pago");
		
		return "base/mediospago/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute MedioPago medioPago) {
		medioPago.setActivo(true);
		medioPago.setNombre(medioPago.getNombre().toUpperCase());
		//medioPago.setTipoMedioPago(medioPago.getTipoMedioPago());
		medioPago.setDepositable(medioPago.isDepositable());
		service.create(medioPago);
		
		return "redirect:/base/mediospago";
	}
	
	
	//Ver mediosPago
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos Medios Pago");

		MedioPago medioPago = service.findById(id);
		model.addAttribute("medioPago", medioPago);
		
		return "base/mediospago/show";
	}
	
	
	
	//Editar medioPago
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Medios de Pago");
		
		MedioPago medioPago = service.findById(id);
		model.addAttribute("medioPago", medioPago);
		return "base/mediospago/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute MedioPago medioPago) {
		medioPago.setId(id);
		service.update(medioPago);
		return "redirect:/base/mediospago";
	}
	
	
	//Eliminar medioPago
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/mediospago";
	}
	
}
