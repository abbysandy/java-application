package com.starter.dao;

import java.util.List;

public interface BaseDAO<T> {

	public List<T> select();

	public T selectById(int id);

	public T newEntity();

	public void create(Object form);

	public Object edit(T entity, Class<?> clazz);

	public void update(T entity, Object form);

	public void delete(T entity);

}
