package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Sucursal;
import com.minegocio.base.repository.SucursalRepository;
import com.minegocio.base.service.dto.SucursalDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class SucursalService extends AbstractService<Sucursal> {
	
	@Autowired
	private SucursalRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public SucursalDto convertToDto(Sucursal sucursal) {
		// TODO Auto-generated method stub
		SucursalDto dto = modelMapper.map(sucursal, SucursalDto.class);
		return dto;
	}

	@Override
	public Sucursal convertToEntity(BaseDto dto) {
		// TODO Auto-generated method stub
		Sucursal sucursal = modelMapper.map((SucursalDto)dto, Sucursal.class);
		return sucursal;
	}

	@Override
	protected JpaRepository<Sucursal, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
}