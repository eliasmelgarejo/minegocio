package com.minegocio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.service.CiudadService;
import com.minegocio.base.service.DepartamentoService;

@SpringBootTest
public class CiudadServiceTest {

	@Autowired
	private CiudadService service;
	@Autowired
	private DepartamentoService serviceDep;
	
	@Test
	public void whenCreateCiudad_thenCorrect() {
		Ciudad entity = new Ciudad();
		entity.setActivo(true);
		entity.setNombre("ASUNCION");
		entity.setDepartamento(serviceDep.findById(1L));
		
		assertThat(service.create(entity)).isNotNull();
	}
	
	
}
