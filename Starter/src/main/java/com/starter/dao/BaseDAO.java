package com.starter.dao;

import java.util.List;

import org.springframework.validation.BindingResult;

public interface BaseDAO<T> {

	public List<T> select();

	public T selectById(int id);

	public T newEntity();

	public void create(Object form);

	public Object edit(T entity);

	public void update(T entity, Object form);

	public void delete(T entity);

	public BindingResult validate(T entity, Object form);

}
