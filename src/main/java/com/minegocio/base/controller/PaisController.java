package com.minegocio.base.controller;


import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.PaisService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/paises")
public class PaisController {

	@Autowired
	private PaisService service;
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam("page") Optional<Integer> page, 
		    @RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Pais> paisPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        
        model.addAttribute("paisPage",paisPage);
        
        int totalPages = paisPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
//		List<Pais> lista = service.findAll();
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Paises");
//		model.addAttribute("lista", lista);
		
		return "base/paises/index";
	}
	
	@GetMapping("new")
	public String create(Model model) {
		return "base/paises/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) { //
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "base/paises/edit";
	}

	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "base/paises/show";
	}

	@PostMapping
	public String create(@ModelAttribute Pais pais) { // ⑥
		service.save(pais);
		return "redirect:/base/paises"; // ⑦
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Pais pais) {
		pais.setId(id);
		service.save(pais);
		return "redirect:/base/paises";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/base/paises";
	}
}
