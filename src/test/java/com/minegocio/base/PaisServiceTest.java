package com.minegocio.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.service.PaisService;
import com.minegocio.base.service.dto.PaisDto;

@SpringBootTest
public class PaisServiceTest {

	@Autowired
	private PaisService service;	
	
	@Test
	public void whenCreatePais_thenCorrect() {
		
		PaisDto pais = PaisDto.builder()
				.gentilicio("Paises")
				.nombre("Paises")
				.build();
		pais.setActivo(true);
		
		assertThat(service.create(service.convertToEntity(pais))).isNotNull();
		
	}
	
	@Test
	public void whenEditPais_thenCorrect() {
		Pais pais;
		pais = service.findByNombre("Paises");
		pais.setGentilicio("PAISANO");
		System.out.println("Update Pais: "+pais.getId().toString());
		assertTrue(service.update(pais).getGentilicio().equals("PAISANO"));
	}
	
	@Test
	public void whenFindAllPaises_thenCorrect() {
		List<Pais> paises = service.findAll();
		assertTrue(paises.size() > 0);
	}
	
	@Test
	public void whenFindByNombrePaises_thenCorrect() {
		Pais pais = service.findByNombre("Paises");
		System.out.println("nombre: "+pais.getNombre());
		assertTrue(pais != null);
	}
	
	@Test
	public void whenDeletePais_tehnCorrect() {
		Pais pais;
		pais = service.findByNombre("Paises");
		System.out.println("Delete Pais: "+pais.getId().toString());
		
		assertTrue(service.delete(pais));
	}
	
}
