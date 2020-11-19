package com.minegocio.base.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.minegocio.base.service.dto.PaisDto;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface PaisService extends IReadService<PaisDto>, IWriteService<PaisDto>{
	Page<PaisDto> findPaginated(Pageable pageable);
	PaisDto findByNombre(String nombre);
}
