package com.starter.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.starter.dao.TagDAO;
import com.starter.entities.TagEntity;

@Repository
public class TagDAOImpl extends BaseDAOImpl implements TagDAO {

	@Override
	public List<TagEntity> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TagEntity> select(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagEntity selectById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagEntity newEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagEntity create(Object form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object edit(TagEntity entity, Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagEntity update(TagEntity entity, Object form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TagEntity entity) {
		// TODO Auto-generated method stub

	}

}
