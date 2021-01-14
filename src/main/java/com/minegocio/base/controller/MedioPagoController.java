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
import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.service.MedioPagoService;
import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;

@Controller
@RequestMapping("/base/mediospago")
public class MedioPagoController implements IController<MedioPago> {

	@Autowired
	private MedioPagoService service;
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<MedioPago> entityPage = service.findPaginated(currentPage-1, pageSize);
        
        model.addAttribute("entityPage",entityPage);
        
        int totalPages = entityPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Medios de Pagos");
		
		return "base/mediospago/index";
	}
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Medio de Pago");
		
		return "base/mediospago/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute MedioPago mediopago) { // ⑥
		mediopago.setActivo(true);
		mediopago.setNombre(mediopago.getNombre().toUpperCase());
		service.create(mediopago);
		
		return "redirect:/base/mediospago"; // ⑦
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Medio de Pago");
		MedioPago mediopago = service.findById(id);
		model.addAttribute("mediopago", mediopago);
		
		return "base/mediospago/show";
	}
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Medio de Pago");
		MedioPago mediopago = service.findById(id);
		model.addAttribute("mediopago", mediopago);

		return "base/mediospago/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute MedioPago mediopago) {
		mediopago.setId(id);
		service.update(mediopago);
		return "redirect:/base/mediospago";
	}
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
	    service.deleteById(id);
	    return "redirect:/base/mediospago";
	}

}