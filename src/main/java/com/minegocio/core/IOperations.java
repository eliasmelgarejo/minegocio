package com.minegocio.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface IOperations<T extends Serializable> {

    // read - one

    T findById(final long id);

    // read - all

    List<T> findAll();

    Page<T> findPaginated(int page, int size);

    // write

    T create(final T entity);

    T update(final T entity);

    boolean delete(final T entity);

    boolean deleteById(final long entityId);
    
    // wrapper dto/entity
    
    BaseDto convertToDto(T entity);
    
    T convertToEntity(BaseDto dto);
}
