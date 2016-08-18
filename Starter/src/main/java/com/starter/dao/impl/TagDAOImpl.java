package com.starter.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.starter.dao.TagDAO;
import com.starter.dao.UserDAO;
import com.starter.entities.TagEntity;
import com.starter.repositories.TagRepository;

@Repository
public class TagDAOImpl extends BaseDAOImpl implements TagDAO {

	@Autowired
	private TagRepository	tagRepository;

	@Autowired
	private UserDAO			userDAO;

	@Override
	public List<TagEntity> select() {
		return this.tagRepository.findAll();
	}

	@Override
	public Iterable<TagEntity> select(Sort sort) {
		return this.tagRepository.findAll(sort);
	}

	@Override
	public Page<TagEntity> select(Pageable pageable) {
		return this.tagRepository.findAll(pageable);
	}

	@Override
	public TagEntity selectById(UUID id) {
		return this.tagRepository.findOne(id);
	}

	@Override
	public TagEntity newEntity() {
		return new TagEntity();
	}

	@Override
	public TagEntity create(Object form) {
		TagEntity tag = new TagEntity();
		tag.setId(UUID.randomUUID());
		tag.setCreatedAt(new Date());
		tag.setCreatedBy(this.userDAO.getCurrentUser());
		return this.update(tag, form);
	}

	@Override
	public Object edit(TagEntity tag, Class<?> clazz) {
		try {
			Object form = clazz.newInstance();
			BeanUtils.copyProperties(tag, form);
			return form;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TagEntity update(TagEntity tag, Object form) {
		if (form != null) {
			BeanUtils.copyProperties(form, tag);
		}
		tag.setUpdatedAt(new Date());
		tag.setUpdatedBy(this.userDAO.getCurrentUser());
		return this.tagRepository.save(tag);
	}

	@Override
	public void delete(TagEntity tag) {
		this.tagRepository.delete(tag);
	}

}
