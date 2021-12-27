package com.minegocio.base;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.base.domain.Departamento;
import com.minegocio.base.service.DepartamentoService;
import com.minegocio.base.service.PaisService;
import com.minegocio.base.service.dto.DepartamentoDto;

@SpringBootTest
public class DepartamentoServiceTest {

	@Autowired
	private DepartamentoService service;
	@Autowired
	private PaisService servicePais;
	
	@Test
	public void whenCreate_thatCorrect() {
		DepartamentoDto dto = new DepartamentoDto();
		dto.setActivo(true);
		dto.setNombre("CENTRAL");
		dto.setPais(servicePais.findByNombre("PARAGUAY"));
						
		assertThat(service.create(service.convertToEntity(dto))).isNotNull();
	}
	
	@Test
	public void whenEdit_thenCorrect() {
		Departamento entity;
		entity = service.findById(2L);
		entity.setNombre("Central2");
		assertTrue(service.update(entity).getNombre().equals("Central2"));
	}
	
	@Test
	public void whenFindAll_thenCorrect() {
		
		List<Departamento> list = service.findAll();
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void whenFindById_thenCorrect() {
		Departamento entity = service.findById(2L);
		assertTrue(entity != null);
	}
	
	@Test
	public void whenDelete_tehnCorrect() {
		Departamento entity;
		entity = service.findById(1L);
		assertTrue(service.delete(entity));
	}
}
