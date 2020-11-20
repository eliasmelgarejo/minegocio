//package com.minegocio.base.service.impl;
//
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.minegocio.base.domain.Departamento;
//import com.minegocio.base.domain.Pais;
//import com.minegocio.base.repository.DepartamentoRepository;
//import com.minegocio.base.service.DepartamentoService;
//import com.minegocio.base.service.dto.DepartamentoDto;
//
//@Service
//@Transactional
//public class DepartamentoServiceImpl implements DepartamentoService{
//
//	@Autowired
//	private DepartamentoRepository repo;
//	
//	@Autowired
//	ModelMapper modelMapper;
//
//	@Override
//	public Departamento findById(Long id) {
//		return repo.getOne(id);
//	}
//
//	@Override
//	public List<Departamento> findAll() {
//		return repo.findAll();
//	}
//
//
//	@Override
//	public Departamento save(Departamento entity) {
//		return (repo.save(entity));
//	}
//
//	@Override
//	public void delete(Long id) {
//		repo.deleteById(id);
//	}
//
//	@Override
//	public List<Departamento> findByPais(Pais pais) {
//		return repo.findByPais(pais);
//	}
//
//	@Override
//	public DepartamentoDto convertToDto(Departamento entity) {
//		DepartamentoDto dto = modelMapper.map(entity, DepartamentoDto.class);
//		return dto;
//	}
//
//	@Override
//	public Departamento convertToEntity(Object dto) {
//		Departamento entity = modelMapper.map((DepartamentoDto)dto, Departamento.class);
//		return entity;
//	}
//
//	
//}
