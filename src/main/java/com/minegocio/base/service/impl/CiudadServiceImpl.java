//package com.minegocio.base.service.impl;
//
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.minegocio.base.domain.Ciudad;
//import com.minegocio.base.domain.Departamento;
//import com.minegocio.base.repository.CiudadRepository;
//import com.minegocio.base.service.CiudadService;
//import com.minegocio.base.service.dto.CiudadDto;
//
//@Service
//@Transactional
//public class CiudadServiceImpl implements CiudadService {
//
//	@Autowired
//	private CiudadRepository repo;
//	
//	@Autowired
//	ModelMapper modelMapper;
//	
//	@Override
//	public Ciudad findById(Long id) {
//		return repo.getOne(id);
//	}
//
//	@Override
//	public List<Ciudad> findAll() {
//		return repo.findAll();
//	}
//
//	@Override
//	public Ciudad save(Ciudad entity) {
//		return repo.save(entity);
//	}
//
//	@Override
//	public void delete(Long id) {
//		repo.deleteById(id);
//	}
//
//	@Override
//	public List<Ciudad> findByDepartamento(Departamento departamento) {
//		return repo.findByDepartamento(departamento);
//	}
//
//	@Override
//	public Object convertToDto(Ciudad entidad) {
//		CiudadDto dto = modelMapper.map(entidad, CiudadDto.class);
//		return dto;
//	}
//
//	@Override
//	public Ciudad convertToEntity(Object dto) {
//		Ciudad entidad = modelMapper.map((CiudadDto)dto, Ciudad.class);
//		return entidad;
//	}
//
//}
