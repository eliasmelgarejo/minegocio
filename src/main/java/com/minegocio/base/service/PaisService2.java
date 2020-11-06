package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.PaisRepository;
import com.minegocio.base.service.dto.PaisDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

public class PaisService2 extends AbstractService<Pais>{
	
	@Autowired
	private PaisRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public PaisDto convertToDto(Pais pais) {
		PaisDto dto = modelMapper.map(pais, PaisDto.class);
		return dto;
	}

	@Override
	public Pais convertToEntity(BaseDto dto) {
		Pais pais = modelMapper.map((PaisDto)dto, Pais.class);
		return pais;
	}

	@Override
	protected PagingAndSortingRepository<Pais, Long> getRepo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
