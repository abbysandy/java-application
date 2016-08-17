package com.starter.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.starter.dao.CategoryDAO;
import com.starter.entities.CategoryEntity;

@Repository
public class CategoryDAOImpl extends BaseDAOImpl implements CategoryDAO {

	@Override
	public List<CategoryEntity> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CategoryEntity> select(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity selectById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity newEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity create(Object form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object edit(CategoryEntity entity, Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryEntity update(CategoryEntity entity, Object form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CategoryEntity entity) {
		// TODO Auto-generated method stub

	}

}
