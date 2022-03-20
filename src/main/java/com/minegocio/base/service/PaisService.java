package com.minegocio.base.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.PaisRepository;
import com.minegocio.base.service.dto.PaisDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class PaisService extends AbstractService<Pais>{
	
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
	protected JpaRepository<Pais, Long> getRepo() {
		return repo;
	}
	
	// custom method
	public Pais findByNombre(String nombre) {
		Pais pais;
		try {
			pais = repo.findByNombre(nombre);
		} catch (Exception e) {
			pais= null;
		}
		return pais;
	}
	
	public Page<Pais> findAllPaginated(Pageable pageable){
		return repo.findAll(pageable);
	}

}