package com.minegocio;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.service.MarcaService;

@SpringBootTest
public class MarcaServiceTest {

	@Autowired
	private MarcaService service;
	
	@Test
	public void whenfindAllMarca_thenCorrect() {
		assertTrue(service.findAll().size() > 0);
	}
	
//	@Test
//	public void whenCreateMarca_thenCorrect() {
//		Marca marca = new Marca();
//		marca.setActivo(true);
//		//marca.setId(1L);
//		marca.setImage(null);
//		marca.setNombre("marca1");
//		Object o = service.create(marca);
//		System.out.println("Hola Mundo...");
//		assertThat(o).isNotNull();
//		
//	}
}
