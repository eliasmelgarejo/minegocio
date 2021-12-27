package com.minegocio.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.service.MarcaService;

@SpringBootTest
public class MarcaServiceTest {

	@Autowired
	private MarcaService service;
	
	@Test
	public void whenCreateMarca_thenCorrect() {
		Marca marca = new Marca();
		marca.setActivo(true);
		//marca.setId(1L);
		marca.setImage(null);
		marca.setNombre("marca1");
		Object o = service.create(marca);
		System.out.println("Hola Mundo...");
		assertThat(o).isNotNull();
		
	}
	
	@Test
	public void whenfindAllMarca_thenCorrect() {
		assertTrue(service.findAll().size() > 0);
	}
}
