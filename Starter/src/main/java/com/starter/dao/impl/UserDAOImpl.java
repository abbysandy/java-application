package com.starter.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.repositories.UserRepository;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

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
	public UserEntity newEntity() {
		return new UserEntity();
	}

	@Override
	public void create(Object form) {
		this.update(new UserEntity(), form);
	}

	@Override
	public Object edit(UserEntity user) {
		UserForm userForm = new UserForm();
		BeanUtils.copyProperties(user, userForm);
		return userForm;
	}

	@Override
	public void update(UserEntity user, Object form) {
		BeanUtils.copyProperties(form, user);
		this.userRepository.save(user);
	}

	@Override
	public void delete(UserEntity user) {
		this.userRepository.delete(user);
	}

	@Override
	public BindingResult validate(UserEntity user, Object form) {
		UserForm userForm = (UserForm) form;
		BindingResult bindingResult = super.validate(userForm);

		if (userForm.getUserName() != null) {
			UserEntity userByUserName = this.userRepository.findByUserName(userForm.getUserName());
			if (userByUserName != null) {
				if (user == null || !user.getId().equals(userByUserName.getId())) {
					bindingResult.addError(new FieldError("userForm", "userName", userForm.getUserName(), false, null, null, "User Name must be be unique."));
				}
			}
		}

		return bindingResult;
	}

}
