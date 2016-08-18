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

import com.starter.dao.PostDAO;
import com.starter.dao.UserDAO;
import com.starter.entities.PostEntity;
import com.starter.repositories.PostRepository;

@Repository
public class PostDAOImpl extends BaseDAOImpl implements PostDAO {

	@Autowired
	private PostRepository	postRepository;

	@Autowired
	private UserDAO			userDAO;

	@Override
	public List<PostEntity> select() {
		return this.postRepository.findAll();
	}

	@Override
	public Iterable<PostEntity> select(Sort sort) {
		return this.postRepository.findAll(sort);
	}

	@Override
	public Page<PostEntity> select(Pageable pageable) {
		return this.postRepository.findAll(pageable);
	}

	@Override
	public PostEntity selectById(UUID id) {
		return this.postRepository.findOne(id);
	}

	@Override
	public PostEntity selectByAlias(String alias) {
		return this.postRepository.findByAlias(alias);
	}

	@Override
	public PostEntity newEntity() {
		return new PostEntity();
	}

	@Override
	public PostEntity create(Object form) {
		PostEntity post = new PostEntity();
		post.setId(UUID.randomUUID());
		post.setCreatedAt(new Date());
		post.setCreatedBy(this.userDAO.getCurrentUser());
		return this.update(post, form);
	}

	@Override
	public Object edit(PostEntity post, Class<?> clazz) {
		try {
			Object form = clazz.newInstance();
			BeanUtils.copyProperties(post, form);
			return form;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PostEntity update(PostEntity post, Object form) {
		if (form != null) {
			BeanUtils.copyProperties(form, post);
		}
		post.setUpdatedAt(new Date());
		post.setUpdatedBy(this.userDAO.getCurrentUser());
		return this.postRepository.save(post);
	}

	@Override
	public void delete(PostEntity post) {
		this.postRepository.delete(post);
	}

}
