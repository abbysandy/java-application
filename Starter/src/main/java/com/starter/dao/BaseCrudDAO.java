package com.starter.dao;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface BaseCrudDAO<T> {

	public Iterable<T> select();

	public Iterable<T> select(Sort sort);

	public Page<T> select(Pageable pageable);

	public T selectById(UUID id);

	public T newEntity();

	public T create(Object form);

	public Object edit(T entity, Class<?> clazz);

	public T update(T entity, Object form);

	public void delete(T entity);

}
