package com.minegocio.base.service;

public interface WriteService<T> {

	T save(T entity);
	void delete(Long id);
}
