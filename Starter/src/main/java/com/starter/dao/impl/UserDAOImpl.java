package com.starter.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.repositories.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> select() {
		return this.userRepository.findAll();
	}

	@Override
	public UserEntity selectById(int id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public void create(UserForm userForm) {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userForm, user);
		this.userRepository.save(user);
	}

	@Override
	public void update(UserEntity user, UserForm userForm) {
		BeanUtils.copyProperties(userForm, user);
		this.userRepository.save(user);
	}

	@Override
	public void delete(UserEntity user) {
		this.userRepository.delete(user);
	}

}
