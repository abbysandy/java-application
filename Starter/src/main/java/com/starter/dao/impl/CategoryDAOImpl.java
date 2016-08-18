package com.starter.dao.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.starter.dao.CategoryDAO;
import com.starter.dao.UserDAO;
import com.starter.entities.CategoryEntity;
import com.starter.repositories.CategoryRepository;

@Repository
public class CategoryDAOImpl extends BaseDAOImpl implements CategoryDAO {

	@Autowired
	private CategoryRepository	categoryRepository;

	@Autowired
	private UserDAO				userDAO;

	@Override
	public Iterable<CategoryEntity> select() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Iterable<CategoryEntity> select(Sort sort) {
		return this.categoryRepository.findAll(sort);
	}

	@Override
	public Page<CategoryEntity> select(Pageable pageable) {
		return this.categoryRepository.findAll(pageable);
	}

	@Override
	public CategoryEntity selectById(UUID id) {
		return this.categoryRepository.findOne(id);
	}

	@Override
	public CategoryEntity newEntity() {
		return new CategoryEntity();
	}

	@Override
	public CategoryEntity create(Object form) {
		CategoryEntity category = new CategoryEntity();
		category.setId(UUID.randomUUID());
		category.setCreatedAt(new Date());
		category.setCreatedBy(this.userDAO.getCurrentUser());
		return this.update(category, form);
	}

	@Override
	public Object edit(CategoryEntity category, Class<?> clazz) {
		try {
			Object form = clazz.newInstance();
			BeanUtils.copyProperties(category, form);
			return form;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryEntity update(CategoryEntity category, Object form) {
		if (form != null) {
			BeanUtils.copyProperties(form, category);
		}
		category.setUpdatedAt(new Date());
		category.setUpdatedBy(this.userDAO.getCurrentUser());
		return this.categoryRepository.save(category);
	}

	@Override
	public void delete(CategoryEntity category) {
		this.categoryRepository.delete(category);
	}

}
