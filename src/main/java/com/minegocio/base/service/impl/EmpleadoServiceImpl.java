/*
 * package com.minegocio.base.service.impl;
 * 
 * import java.util.List;
 * 
 * import org.modelmapper.ModelMapper; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.minegocio.base.domain.Empleado; import
 * com.minegocio.base.repository.EmpleadoRepository; import
 * com.minegocio.base.service.EmpleadoService; import
 * com.minegocio.base.service.dto.EmpleadoDto;
 * 
 * @Service
 * 
 * @Transactional public class EmpleadoServiceImpl implements EmpleadoService{
 * 
 * @Autowired private EmpleadoRepository repo;
 * 
 * @Autowired ModelMapper modelMapper;
 * 
 * @Override public Empleado findById(Long id) { return repo.getOne(id); }
 * 
 * @Override public List<Empleado> findAll() { return repo.findAll(); }
 * 
 * 
 * @Override public Empleado save(Empleado entity) { return (repo.save(entity));
 * }
 * 
 * @Override public void delete(Long id) { repo.deleteById(id); }
 * 
 * @Override public EmpleadoDto convertToDto(Empleado entity) { EmpleadoDto dto
 * = modelMapper.map(entity, EmpleadoDto.class); return dto; }
 * 
 * @Override public Empleado convertToEntity(Object dto) { Empleado entity =
 * modelMapper.map((EmpleadoDto)dto, Empleado.class); return entity; }
 * 
 * @Override public Empleado findByDocumento(String documento) { return
 * repo.findByDocumento(documento); }
 * 
 * 
 * }
 */