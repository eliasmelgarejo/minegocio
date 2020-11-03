package com.minegocio.base.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.minegocio.base.domain.Pais;
import com.minegocio.core.IOperations;

public interface PaisService extends IOperations<Pais>{
	
	Page<Pais> findPaginated(Pageable pageable);
	
}
