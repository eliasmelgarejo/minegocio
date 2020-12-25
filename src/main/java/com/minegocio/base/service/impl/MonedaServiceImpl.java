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
 * import com.minegocio.base.domain.Moneda; import
 * com.minegocio.base.domain.Pais; import
 * com.minegocio.base.repository.MonedaRepository; import
 * com.minegocio.base.service.MonedaService; import
 * com.minegocio.base.service.dto.MonedaDto;
 * 
 * @Service
 * 
 * @Transactional public class MonedaServiceImpl implements MonedaService{
 * 
 * @Autowired private MonedaRepository repo;
 * 
 * @Autowired ModelMapper modelMapper;
 * 
 * @Override public Moneda findById(Long id) { return repo.getOne(id); }
 * 
 * @Override public List<Moneda> findAll() { return repo.findAll(); }
 * 
 * 
 * @Override public Moneda save(Moneda entity) { return (repo.save(entity)); }
 * 
 * @Override public void delete(Long id) { repo.deleteById(id); }
 * 
 * @Override public MonedaDto convertToDto(Moneda entity) { MonedaDto dto =
 * modelMapper.map(entity,MonedaDto.class); return dto; }
 * 
 * @Override public Moneda convertToEntity(Object o) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public List<Moneda> findByPais(Pais pais) { return
 * repo.findByPais(pais); }
 * 
 * @Override public List<Moneda> findByBaseTrue() { return
 * repo.findByBaseTrue(); }
 * 
 * @Override public List<Moneda> findByBaseTrueAndPais(Pais pais) { return
 * repo.findByBaseTrueAndPais(pais); } }
 */