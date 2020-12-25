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
 * import com.minegocio.base.domain.MedioPago; import
 * com.minegocio.base.service.MedioPagoService; import
 * com.minegocio.config.ConfigModulosMenus; import
 * com.minegocio.core.IController;
 * 
 * @Controller
 * 
 * @RequestMapping("/base/mediospago") public class MedioPagoController
 * implements IController {
 * 
 * @Autowired private MedioPagoService service;
 * 
 * @Override
 * 
 * @GetMapping public String index(Model model) { List<MedioPago> lista =
 * service.findAll(); model.addAttribute("modulo",
 * " "+ConfigModulosMenus.base().nombre.toUpperCase());
 * model.addAttribute("menus", ConfigModulosMenus.base().menus);
 * model.addAttribute("titulo_listado","Listado de Medios de Pagos");
 * model.addAttribute("lista", lista); return "/base/mediospago/index"; }
 * 
 * @Override
 * 
 * @GetMapping("new") public String create(Model model) { return
 * "base/mediospago/new"; }
 * 
 * @Override
 * 
 * @PostMapping public String create(@ModelAttribute Object entity) { // ⑥
 * service.save((MedioPago)entity); return "redirect:/base/mediospago"; // ⑦ }
 * 
 * @Override
 * 
 * @GetMapping("{id}/edit") public String edit(@PathVariable Long id, Model
 * model) { // MedioPago entity = service.findById(id);
 * model.addAttribute("entity", entity); return "base/mediospago/edit"; }
 * 
 * @Override
 * 
 * @GetMapping("{id}") public String show(@PathVariable Long id, Model model) {
 * MedioPago entity = service.findById(id); model.addAttribute("entity",
 * entity); return "base/mediospago/show"; }
 * 
 * @Override
 * 
 * @PutMapping("{id}") public String update(@PathVariable Long
 * id, @ModelAttribute Object entity) { ((MedioPago) entity).setId(id);
 * service.save((MedioPago)entity); return "redirect:/base/mediospago"; }
 * 
 * @Override
 * 
 * @DeleteMapping("{id}") public String destroy(@PathVariable Long id) {
 * service.delete(id); return "redirect:/base/mediospago"; } }
 */




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
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.MedioPagoService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/mediospago")
public class MedioPagoController {

	@Autowired
	private MedioPagoService service;
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<MedioPago> medioPagoPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("medioPagoPage",medioPagoPage);
        
        int totalPages = medioPagoPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        

		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Medios de Pago");

		
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
	public String create(@ModelAttribute MedioPago medioPago) { // ⑥
		medioPago.setActivo(true);
		medioPago.setNombre(medioPago.getNombre().toUpperCase());
		medioPago.setTipoMedioPago(medioPago.getTipoMedioPago());
		service.create(medioPago);
		
		return "redirect:/base/mediospago"; // ⑦
	}
	
	
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Medios de Pago");

		MedioPago medioPago = service.findById(id);
		model.addAttribute("medioPago", medioPago);
		
		return "base/mediospago/show";
	}
	
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
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
	
	
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/mediospago";
	}
	
	
}
