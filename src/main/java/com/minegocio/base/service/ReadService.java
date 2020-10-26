package com.minegocio.base.service;

import java.util.List;

public interface ReadService<T> {
	
	T findById(Long id);
	List<T> findAll();
	
}
