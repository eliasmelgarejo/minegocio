package com.minegocio.inventario.controller;

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

import com.minegocio.config.ConfigModulosMenus;
import com.minegocio.core.IController;
import com.minegocio.inventario.domain.Categoria;
import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.domain.Producto;
import com.minegocio.inventario.service.CategoriaService;
import com.minegocio.inventario.service.MarcaService;
import com.minegocio.inventario.service.ProductoService;

@Controller
@RequestMapping("/inventario/productos")
public class ProductoController implements IController<Producto> {
	
	/* MARK */
	/*
	HASTA AQUI LLEGUE, HICE TODO EL PROCESO DE NUEVO REGISTRO PERO NO INSERTA, NO MUESTRA
	LA LISTA, NO MUESTRA SHOW, NO ACTUALIZA, Y DESPUES DE REALIZAR TODO ESTE PROCESO
	NO ESTA FUNCIONANDO LAS OTRAS PANTALLAS DE INVENTARIO
	*/
	
	@Autowired
	private ProductoService service;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private MarcaService marcaService;
	
	//Listado de Productos
	@GetMapping
	public String index(
			Model model,
			@RequestParam(defaultValue="1") int page, 
		    @RequestParam(defaultValue="5") int size) {
		
		int currentPage = page;
        int pageSize = size;
        
        Page<Producto> entityPage = service.findPaginated(currentPage-1, size);
        model.addAttribute("entityPage", entityPage);
        
        int totalPages = entityPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_listado","Lista Productos");
		
		return "inventario/productos/index";
	}
	
	
	//Crear Nuevo producto
	@GetMapping("new")
	public String create(Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Crear Nuevo Producto");
		
		model.addAttribute("lista_categorias", categoriaService.findAll());
		model.addAttribute("lista_marcas", marcaService.findAll());
		
		return "inventario/productos/new";
	}
	
	@PostMapping("create")
	public String create(@ModelAttribute Producto producto) {
		producto.setActivo(true);
		producto.setCodigo(producto.getCodigo());
		producto.setCodigobarras(producto.getCodigobarras());
		producto.setDescripcioncorta(producto.getDescripcioncorta());
		producto.setDescripcionlarga(producto.getDescripcionlarga());
		producto.setInventariable(producto.getInventariable());
		producto.setPerecedero(producto.getPerecedero());
		producto.setServicio(producto.getServicio());
		producto.setTienelote(producto.getTienelote());
		
		Categoria c = categoriaService.findByNombre(producto.getCategoria().getNombre());
		producto.setCategoria(c);
		
		Marca m = marcaService.findByNombre(producto.getMarca().getNombre());
		producto.setMarca(m);
		
		service.create(producto);
		return "redirect:/inventario/productos";
	}
	
	
	
	//Ver producto
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Datos Producto");
		
		Producto producto = service.findById(id);
		model.addAttribute("producto", producto);
		
		return "inventario/productos/show";
	}
	
	
	
	//Editar producto
	@GetMapping("edit={id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("modulo", " "+ConfigModulosMenus.inventario().nombre.toUpperCase());
		model.addAttribute("menus", ConfigModulosMenus.inventario().menus);
		model.addAttribute("titulo_cuerpo","Actualizar Datos");
		
		Producto producto = service.findById(id);
		model.addAttribute("producto", producto);
		
		model.addAttribute("lista_categorias", categoriaService.findAll());
		model.addAttribute("lista_marcas", marcaService.findAll());
		
		return "inventario/productos/edit";
	}

	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Producto producto) {
		Categoria c = categoriaService.findByNombre(producto.getCategoria().getNombre());
		producto.setCategoria(c);
		
		Marca m = marcaService.findByNombre(producto.getMarca().getNombre());
		producto.setMarca(m);
		
		producto.setId(id);
		service.update(producto);
		return "redirect:/inventario/productos";
	}

	
	//Eliminar producto
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
		Producto entity = service.findById(id);
		boolean result = service.delete(entity); 
		return "redirect:/inventario/productos";
	}
	
}
