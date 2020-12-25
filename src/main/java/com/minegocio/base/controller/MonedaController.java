/*
 * package com.minegocio.base.controller;
 * 
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.minegocio.base.domain.Moneda; import
 * com.minegocio.base.service.MonedaService; import
 * com.minegocio.config.ConfigModulosMenus; import
 * com.minegocio.core.IController;
 * 
 * @Controller
 * 
 * @RequestMapping("/base/monedas") public class MonedaController implements
 * IController {
 * 
 * @Autowired private MonedaService service;
 * 
 * @Override
 * 
 * @GetMapping public String index(Model model) { List<Moneda> lista =
 * service.findAll(); model.addAttribute("modulo",
 * " "+ConfigModulosMenus.base().nombre.toUpperCase());
 * model.addAttribute("menus", ConfigModulosMenus.base().menus);
 * model.addAttribute("titulo_listado","Listado de Monedas");
 * model.addAttribute("lista", lista); return "/base/monedas/index"; }
 * 
 * @Override
 * 
 * @GetMapping("new") public String create(Model model) { return
 * "base/monedas/new"; }
 * 
 * @Override
 * 
 * @PostMapping public String create(@ModelAttribute Object entity) { // ⑥
 * service.save((Moneda)entity); return "redirect:/base/monedas"; // ⑦ }
 * 
 * @Override
 * 
 * @GetMapping("{id}/edit") public String edit(@PathVariable Long id, Model
 * model) { // Moneda entity = service.findById(id);
 * model.addAttribute("entity", entity); return "base/monedas/edit"; }
 * 
 * @Override
 * 
 * @GetMapping("{id}") public String show(@PathVariable Long id, Model model) {
 * Moneda entity = service.findById(id); model.addAttribute("entity", entity);
 * return "base/monedas/show"; }
 * 
 * @Override
 * 
 * @PutMapping("{id}") public String update(@PathVariable Long
 * id, @ModelAttribute Object entity) { ((Moneda) entity).setId(id);
 * service.save((Moneda)entity); return "redirect:/base/monedas"; }
 * 
 * @Override
 * 
 * @DeleteMapping("{id}") public String destroy(@PathVariable Long id) {
 * service.delete(id); return "redirect:/base/monedas"; } }
 */




package com.minegocio.base.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minegocio.base.domain.Moneda;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.MonedaService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/monedas")
public class MonedaController{
	
	@Autowired
	private MonedaService service;
	
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Moneda> monedaPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("monedaPage",monedaPage);
        
        int totalPages = monedaPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        

		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Monedas");

		
		return "base/monedas/index";
	}
	
	
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Moneda");
		//return "base/paises/new";
		return "base/monedas/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Moneda moneda) { // ⑥
		//pais.setActivo(true);
		//pais.setNombre(pais.getNombre().toUpperCase());
		//pais.setGentilicio(pais.getGentilicio().toUpperCase());
		//service.create(pais);
		//return "redirect:/base/paises"; // ⑦
		
		moneda.setActivo(true);
		moneda.setSimbolo(moneda.getSimbolo().toUpperCase());
		//moneda.setGentilicio(moneda.getGentilicio().toUpperCase());
		service.create(moneda);
		return "redirect:/base/monedas";
	}
	
	
	
	
	
}