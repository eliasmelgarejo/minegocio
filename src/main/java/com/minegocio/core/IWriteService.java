package com.minegocio.core;

public interface IWriteService<T> {

	T save(T entity);
	void delete(Long id);
}
