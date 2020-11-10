package com.minegocio.base.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.minegocio.base.domain.Pais;
import com.minegocio.core.IReadService;
import com.minegocio.core.IWriteService;

public interface PaisService extends IReadService<Pais>, IWriteService<Pais>{
	Page<Pais> findPaginated(Pageable pageable);
}
