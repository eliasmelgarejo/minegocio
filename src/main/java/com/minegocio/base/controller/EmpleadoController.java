/*
 * package com.minegocio.base.controller;
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
 * import com.minegocio.base.domain.Empleado; import
 * com.minegocio.base.service.EmpleadoService; import
 * com.minegocio.config.ConfigModulosMenus; import
 * com.minegocio.core.IController;
 * 
 * @Controller
 * 
 * @RequestMapping("/base/empleados") public class EmpleadoController implements
 * IController{
 * 
 * @Autowired private EmpleadoService service;
 * 
 * @Override
 * 
 * @GetMapping public String index(Model model) { List<Empleado> lista =
 * service.findAll(); model.addAttribute("modulo",
 * " "+ConfigModulosMenus.base().nombre.toUpperCase());
 * model.addAttribute("menus", ConfigModulosMenus.base().menus);
 * model.addAttribute("titulo_listado","Listado de Empleados");
 * model.addAttribute("lista", lista); return "/base/empleados/index"; }
 * 
 * @Override
 * 
 * @GetMapping("new") public String create(Model model) { return
 * "base/empleados/new"; }
 * 
 * @Override
 * 
 * @PostMapping public String create(@ModelAttribute Object empleado) { // ⑥
 * service.save((Empleado)empleado); return "redirect:/base/empleados"; // ⑦ }
 * 
 * @Override
 * 
 * @GetMapping("{id}/edit") public String edit(@PathVariable Long id, Model
 * model) { // Empleado empleado = service.findById(id);
 * model.addAttribute("empleado", empleado); return "base/empleados/edit"; }
 * 
 * @Override
 * 
 * @GetMapping("{id}") public String show(@PathVariable Long id, Model model) {
 * Empleado empleado = service.findById(id); model.addAttribute("empleado",
 * empleado); return "base/empleados/show"; }
 * 
 * @Override
 * 
 * @PutMapping("{id}") public String update(@PathVariable Long
 * id, @ModelAttribute Object empleado) { ((Empleado) empleado).setId(id);
 * service.save((Empleado)empleado); return "redirect:/base/empleados"; }
 * 
 * @Override
 * 
 * @DeleteMapping("{id}") public String destroy(@PathVariable Long id) {
 * service.delete(id); return "redirect:/base/empleados"; }
 * 
 * 
 * }
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

import com.minegocio.base.domain.Empleado;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.EmpleadoService;
import com.minegocio.config.ConfigModulosMenus;

@Controller
@RequestMapping("/base/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService service;
	
	
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        Page<Empleado> empleadoPage = service.findPaginated(currentPage-1, size);
        
        model.addAttribute("empleadoPage",empleadoPage);
        
        int totalPages = empleadoPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        

		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_listado","Listado de Empleados");
		
		return "base/empleados/index";
	}
	
	
	
	
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Crear Empleado");
		return "base/empleados/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Empleado empleado) { // ⑥
		empleado.setActivo(true);
		empleado.setCodigo(empleado.getCodigo());
		//pais.setGentilicio(pais.getGentilicio().toUpperCase());
		service.create(empleado);
		return "redirect:/base/empleados"; // ⑦
	}
	
	
	
	
	
	
	
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Datos de Empleado");
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado", empleado);
		return "base/empleados/show";
	}
	
	
	
	
	
	
	
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) { //
		model.addAttribute("modulo", " "+ConfigModulosMenus.base().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.base().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Empleado");
		Empleado empleado = service.findById(id);
		model.addAttribute("empleado", empleado);
		return "base/empleados/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Empleado empleado) {
		empleado.setId(id);
		service.update(empleado);
		return "redirect:/base/empleados";
	}

	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/base/empleados";
	}
	
	
	
}
