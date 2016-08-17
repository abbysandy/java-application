package com.starter.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.starter.dao.PostDAO;
import com.starter.entities.PostEntity;

@Repository
public class PostDAOImpl extends BaseDAOImpl implements PostDAO {

	@Override
	public List<PostEntity> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PostEntity> select(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostEntity selectById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostEntity newEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostEntity create(Object form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object edit(PostEntity entity, Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostEntity update(PostEntity entity, Object form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PostEntity entity) {
		// TODO Auto-generated method stub

	}

}
