package com.minegocio.base.service.impl;

import java.util.ArrayList;
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
	public PaisDto findById(Long id) {
		PaisDto dto = convertToEntity(repo.getOne(id));
		return dto;
	}

	@Override
	public List<PaisDto> findAll() {
		List<PaisDto> list = new ArrayList<PaisDto>();
		for (Pais pais : repo.findAll()) {
			PaisDto dto = convertToEntity(pais);
			list.add(dto);
		}
		return list;
	}


	@Override
	public PaisDto save(PaisDto dto) {
		Pais pais = convertToDto(dto);
		repo.saveAndFlush(pais);
		System.out.println("Updaet Pais: "+pais.getId().toString());
		PaisDto val = convertToEntity(pais);
		return val;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	
	
	@Override
	public Pais convertToDto(PaisDto dto) {
		Pais pais = modelMapper.map(dto, Pais.class);
		return pais;
	}

	@Override
	public PaisDto convertToEntity(Object entity) {
		PaisDto dto = modelMapper.map((Pais)entity, PaisDto.class);
		return dto;
	}

	public Page<PaisDto> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;        
        List<Pais> list;
        List<PaisDto> listDto = new ArrayList<PaisDto>();
        
        if (repo.count() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = (int) Math.min(startItem + pageSize, repo.count());
            list = repo.findAll(pageable).getContent().subList(startItem, toIndex);
            for (Pais pais : list) {
				PaisDto dto = convertToEntity(pais);
				listDto.add(dto);
			}
        }
 
        Page<PaisDto> paisPage
          = new PageImpl<PaisDto>(listDto, PageRequest.of(currentPage, pageSize), repo.count());
 
        return paisPage;
    }
	
}
