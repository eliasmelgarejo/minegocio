package com.minegocio.base.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.PaisRepository;
import com.minegocio.base.service.PaisService;
import com.minegocio.base.service.dto.PaisDto;
import com.minegocio.core.AbstractService;

@Service
@Transactional
public class PaisServiceImpl extends AbstractService<Pais> implements PaisService{

	@Autowired
	private PaisRepository repo;
	
	@Autowired
	ModelMapper modelMapper;
	
	// API

    @Override
    protected PagingAndSortingRepository<Pais, Long> getRepo() {
        return repo;
    }

	@Override
	public PaisDto convertToDto(Pais pais) {
		PaisDto dto = modelMapper.map(pais, PaisDto.class);
		return dto;
	}

	@Override
	public Pais convertToEntity(Object dto) {
		Pais pais = modelMapper.map((PaisDto)dto,Pais.class); 
		return pais;
	}

	@Override
	public Page<Pais> findPaginated(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
    @Transactional(readOnly = true)
    public List<Pais> findAll() {
        return Lists.newArrayList(getRepo().findAll());
    }
	
}
