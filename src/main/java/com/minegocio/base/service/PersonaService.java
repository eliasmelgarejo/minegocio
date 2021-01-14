package com.minegocio.base.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegocio.base.domain.Persona;
import com.minegocio.base.repository.PersonaRepository;
import com.minegocio.base.service.dto.PersonaDto;
import com.minegocio.core.AbstractService;
import com.minegocio.core.BaseDto;

@Service
@Transactional
public class PersonaService extends AbstractService<Persona>{
	
	@Autowired
	private PersonaRepository repo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public PersonaDto convertToDto(Persona persona) {
		PersonaDto dto = modelMapper.map(persona, PersonaDto.class);
		return dto;
	}

	@Override
	public Persona convertToEntity(BaseDto dto) {
		Persona persona = modelMapper.map((PersonaDto)dto, Persona.class);
		return persona;
	}

	@Override
	protected JpaRepository<Persona, Long> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	// custom method
	/*public Persona findByNombre(String nombre) {
		Persona persona;
		try {
			persona = repo.findByNombre(nombre);
		} catch (Exception e) {
			persona = null;
		}
		return persona;
	}*/

}