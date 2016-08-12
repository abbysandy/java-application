package com.starter.dao;

import java.util.List;

public interface BaseDAO<T> {

	public List<T> select();

	public T selectById(int id);

	public T newEntity();

	public T create(Object form);

	public Object edit(T entity, Class<?> clazz);

	public T update(T entity, Object form);

	public void delete(T entity);

}
