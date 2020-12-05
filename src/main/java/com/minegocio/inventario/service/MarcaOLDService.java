
package com.minegocio.inventario.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;
import com.minegocio.core.IOperations;
import com.minegocio.inventario.domain.Marca;
import com.minegocio.inventario.repository.MarcaRepository;
import com.minegocio.inventario.service.dto.MarcaDto;

@Service
@Transactional
public class MarcaOLDService extends AbstractService<Marca> implements IOperations<Marca>{
	
	@Autowired
	private MarcaRepository	repo;
	@Autowired
	private ModelMapper	modelMapper;

	@Override
	public MarcaDto convertToDto(Marca marca) {
		MarcaDto dto = modelMapper.map(marca, MarcaDto.class);
		return dto;
	}

	@Override
	public Marca convertToEntity(BaseDto dto) {
		Marca marca = modelMapper.map((MarcaDto)dto, Marca.class);
		return marca;
	}

	@Override
	protected JpaRepository<Marca,Long> getRepo() {		
		return repo;
	}

}


