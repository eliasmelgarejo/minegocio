package com.minegocio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.PaisService;
import com.minegocio.base.service.dto.PaisDto;
import com.minegocio.base.service.impl.PaisServiceImpl;

@SpringBootTest
public class PaisServiceTest {

	@Autowired
	private PaisService service;
	
//	@Test
//	public void whenCreatePais_thenCorrect() {
//		
//		Pais pais = new Pais();
//		pais.setActivo(true);
//		pais.setGentilicio("Argentino/a");
//		pais.setNombre("Argentina");
//		
//		assertThat(service.save(pais)).isNotNull();
//		
//	}
	
	@Test
	public void whenEditPais_thenCorrect() {
		PaisDto pais;
		pais = service.findById(1L);
		pais.setGentilicio("PARAGUAYA/O");
		//pais.setId(1L);
		assertTrue(service.save(pais).getGentilicio().equals("PARAGUAYA/O"));
	}
	
	@Test
	public void whenFindAllPaises_thenCorrect() {
		List<PaisDto> paises = service.findAll();
		assertTrue(paises.size() > 0);
	}
	
}
