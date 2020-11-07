package com.minegocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.repository.MarcaRepository;
import com.minegocio.inventario.service.dto.MarcaDto;

@SpringBootTest
class MiNegocioApplicationTests {
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private MarcaRepository repo;

	@Test
	void whenConvertMarcaEntityToMarcaDto_thenCorrect() {
		Marca marca = new Marca();
		marca.setActivo(true);
		marca.setId(1l);
		marca.setImage(null);
		marca.setNombre("marca 1");
		
		MarcaDto dto = modelMapper.map(marca,MarcaDto.class);
		assertEquals(marca.getId(), dto.getId());
		assertEquals(marca.getNombre(), dto.getNombre());
	}
	
	@Test
	public void whenConvertMarcaDtoToMarcaEntity_thenCorrect() {
		MarcaDto dto = new MarcaDto();
		dto.setActivo(true);
		dto.setId(1l);
		dto.setNombre("marca 2");
		
		Marca marca = modelMapper.map(dto, Marca.class);
		assertEquals(dto.getId(), marca.getId());
		assertEquals(dto.getNombre(), marca.getNombre());
	}
	
}
