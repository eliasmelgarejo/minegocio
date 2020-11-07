package com.minegocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.repository.MarcaRepository;

@SpringBootTest
public class MarcaRepositoryTest {

	@Autowired
	private MarcaRepository repo;
	
	@Test
	public void whenCreateMarca_thenCorrect() {
		Marca marca = new Marca();
		marca.setActivo(true);
		//marca.setId(1L);
		marca.setImage(null);
		marca.setNombre("marca1");
		repo.saveAndFlush(marca);
		assertEquals(repo.getOne(1L).getId(), marca.getId());
		
	}

	@Test
	public void whenEditMarca_thenCorrect() {
		Marca marca = repo.getOne(1L);
		marca.setNombre("marca 1");
		repo.saveAndFlush(marca);
		marca = repo.getOne(1L);
		System.out.println(marca.getId()+"-"+marca.getNombre());
		assertEquals(marca.getNombre(), "marca 1");
	}
	
	@Test
	public void whenMarcaDelete_thenCorrect() {
		Marca marca = repo.getOne(1L);
		repo.delete(marca);
		repo.flush();
		assertEquals(repo.getOne(1L), null);
	}
}
