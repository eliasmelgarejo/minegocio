package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Empleado;
import com.minegocio.base.repository.EmpleadoRepository;
import com.minegocio.base.service.dto.EmpleadoDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class EmpleadoService extends AbstractService<Empleado> {
	
	@Autowired
	private EmpleadoRepository repo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseDto convertToDto(Empleado entity) {
		EmpleadoDto dto = modelMapper.map(entity, EmpleadoDto.class);
		return dto;
	}

	@Override
	public Empleado convertToEntity(BaseDto dto) {
		Empleado entity = modelMapper.map((EmpleadoDto)dto, Empleado.class);
		return entity;
	}

	@Override
	protected JpaRepository<Empleado, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}


	public Empleado findByDocumento(String documento) {
		return repo.findByDocumento(documento);
	}
}
