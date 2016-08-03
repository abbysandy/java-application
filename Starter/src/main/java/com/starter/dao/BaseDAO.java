package com.starter.dao;

import java.util.List;

public interface BaseDAO<T, K> {

	public List<T> select();

	public T selectById(int id);

	public void create(K form);

	public void update(T entity, K form);

	public void delete(T entity);

}
