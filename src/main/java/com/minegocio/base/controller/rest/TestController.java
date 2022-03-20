package com.minegocio.base.controller.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minegocio.base.service.dto.PaisDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("/all")
	public PaisDto allAccess() {
		return PaisDto.builder()
				.nombre("paraguay")
				.gentilicio("paraguayo")
				.build();
	}
}
