package com.minegocio.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;


@Transactional
@Service
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

	//read - one
	@Override
	@Transactional(readOnly = true)
	public T findById(final long id) {
		return getRepo().findById(id).orElse(null);
	}

	//read - all
	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		List<T> l;
		try {
			l = Lists.newArrayList(getRepo().findAll());
		} catch (Exception e) {
			l = null;
		}
		
		return l;
	}

	@Override
	public Page<T> findPaginated(final int page, final int size) {
		Page<T> p;
		try {
			p = getRepo().findAll(PageRequest.of(page, size));
		} catch (Exception e) {
			p = null;
		}
		
		return p;
	}

	//write
	@Override
	public T create(final T entity) {
		T t;
		try {
			t = getRepo().save(entity);
		} catch (Exception e) {
			t = null;
		}
		
		return t;
	}

	@Override
	public T update(final T entity) {
		T t;
		try {
			t = getRepo().save(entity);
		} catch (Exception e) {
			t = null;
		}
		
		return t;
	}

	@Override
	public boolean delete(final T entity) {
		boolean result;
		try {
			if (entity != null) {
				getRepo().delete(entity);
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean deleteById(final long entityId) {
		boolean result;
		try {
			if (entityId == 0) {
			//if (entityId > 0) {
				//System.out.println("ENTRO EN EL IF "+entityId);
				getRepo().deleteById(entityId);
				result = true;
			} else {
				//System.out.println("ENTRO EN EL ELSE "+entityId);
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}

	protected abstract JpaRepository<T, Long> getRepo();

}
