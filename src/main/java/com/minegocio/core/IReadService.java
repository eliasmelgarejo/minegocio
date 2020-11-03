package com.minegocio.core;

import java.util.List;

public interface IReadService<T> {
	
	T findById(Long id);
	List<T> findAll();
	// 	wrapper dto/entity
    Object convertToDto(T t);
    T convertToEntity(Object o);
}
