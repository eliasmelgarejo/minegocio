package com.minegocio.base.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Ciudad;
import com.minegocio.base.repository.CiudadRepository;
import com.minegocio.base.service.dto.CiudadDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class CiudadService extends AbstractService<Ciudad>{
	
	@Autowired
	private CiudadRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CiudadDto convertToDto(Ciudad entity) {
		CiudadDto dto = modelMapper.map(entity, CiudadDto.class);
		return dto;
	}

	@Override
	public Ciudad convertToEntity(BaseDto dto) {
		Ciudad ciudad = modelMapper.map((CiudadDto)dto, Ciudad.class);
		return ciudad;
	}

	@Override
	protected JpaRepository<Ciudad, Long> getRepo() {
		return this.repo;
	}
	
	//custom
	/*public List<Ciudad> findByDepartamento(Departamento departamento){
		List<Ciudad> list;
		try {
			list = repo.findByDepartamento(departamento);
		} catch (Exception e) {
			list = null;
		}
		return list;
	}*/
	
}
