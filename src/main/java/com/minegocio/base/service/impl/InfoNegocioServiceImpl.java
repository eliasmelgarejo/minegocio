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
 * import com.minegocio.base.domain.InfoNegocio; import
 * com.minegocio.base.repository.InfoNegocioRepository; import
 * com.minegocio.base.service.InfoNegocioService; import
 * com.minegocio.base.service.dto.InfoNegocioDto;
 * 
 * @Service
 * 
 * @Transactional public class InfoNegocioServiceImpl implements
 * InfoNegocioService{
 * 
 * @Autowired private InfoNegocioRepository repo;
 * 
 * @Autowired ModelMapper modelMapper;
 * 
 * @Override public InfoNegocio save(InfoNegocio entity) { return
 * (repo.save(entity)); }
 * 
 * @Override public void delete(Long id) { repo.deleteById(id); }
 * 
 * @Override public InfoNegocio findById(Long id) { return repo.getOne(id); }
 * 
 * @Override public List<InfoNegocio> findAll() { return repo.findAll(); }
 * 
 * @Override public InfoNegocioDto convertToDto(InfoNegocio entity) {
 * InfoNegocioDto dto = modelMapper.map(entity, InfoNegocioDto.class); return
 * dto; }
 * 
 * @Override public InfoNegocio convertToEntity(Object dto) { InfoNegocio entity
 * = modelMapper.map(dto, InfoNegocio.class); return entity; }
 * 
 * 
 * }
 */