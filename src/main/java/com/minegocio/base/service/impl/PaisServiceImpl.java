package com.minegocio.base.service.impl;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Pais;
import com.minegocio.base.repository.PaisRepository;
import com.minegocio.base.service.PaisService;
import com.minegocio.base.service.dto.PaisDto;

@Service
@Transactional
public class PaisServiceImpl implements PaisService{

	@Autowired
	private PaisRepository repo;
	
	@Autowired
	ModelMapper modelMapper;

		
	@Override
	public Pais findById(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Pais> findAll() {
		return repo.findAll();
	}


	@Override
	public Pais save(Pais entity) {
		return (repo.saveAndFlush(entity));
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public PaisDto convertToDto(Pais entity) {
		PaisDto dto = modelMapper.map(entity, PaisDto.class);
		return dto;
	}
	
	@Override
	public Pais convertToEntity(Object dto) {
		Pais entity = modelMapper.map((PaisDto)dto, Pais.class);
		return entity;
	}
	
	public Page<Pais> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;        
        List<Pais> list;
        
        if (repo.count() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = (int) Math.min(startItem + pageSize, repo.count());
            list = repo.findAll(pageable).getContent().subList(startItem, toIndex);
        }
 
        Page<Pais> paisPage
          = new PageImpl<Pais>(list, PageRequest.of(currentPage, pageSize), repo.count());
 
        return paisPage;
    }
	
}
