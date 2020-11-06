package com.minegocio.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    // read - one

    @Override
    @Transactional(readOnly = true)
    public T findById(final long id) {
        return getRepo().findById(id).orElse(null);
    }

    // read - all

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getRepo().findAll());
    }

    @Override
    public Page<T> findPaginated(final int page, final int size) {
        return getRepo().findAll(PageRequest.of(page, size));
    }

    // write
    
    @Override
    public T create(final T entity) {
        return getRepo().save(entity);
    }
    
    @Override
    public T update(final T entity) {
        return getRepo().save(entity);
    }

    @Override
    public void delete(final T entity) {
        getRepo().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getRepo().deleteById(entityId);
    }

    protected abstract JpaRepository<T, Long> getRepo();

}