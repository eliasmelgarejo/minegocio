package com.minegocio.base.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.PaisService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pais")
public class PaisRestController {

	@Autowired
	private PaisService service;
	
	@GetMapping("/")
	public Page<Pais> all(Pageable pageable){
		return service.findAllPaginated(pageable);
	}
	
	
	
}
