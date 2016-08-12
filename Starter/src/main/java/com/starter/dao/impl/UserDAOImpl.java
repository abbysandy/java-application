package com.starter.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.forms.UserPasswordForm;
import com.starter.forms.UserRegistrationForm;
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
	public UserEntity selectByUserName(String userName) {
		return this.userRepository.findByUserName(userName);
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
	public Object edit(UserEntity user, Class<?> clazz) {
		try {
			Object form = clazz.newInstance();
			BeanUtils.copyProperties(user, form);
			return form;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
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
	public BindingResult validate(UserEntity user, UserForm userForm) {
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

	@Override
	public BindingResult validate(UserPasswordForm userPasswordForm) {
		BindingResult bindingResult = super.validate(userPasswordForm);

		if (userPasswordForm.getPassword() != null && userPasswordForm.getConfirmPassword() != null) {
			if (!userPasswordForm.getPassword().equals(userPasswordForm.getConfirmPassword())) {
				bindingResult.addError(new FieldError("userPasswordForm", "password", null, false, null, null, "Passwords must match."));
			}
		}

		return bindingResult;
	}

	@Override
	public BindingResult validate(UserRegistrationForm userRegistrationForm) {
		BindingResult bindingResult = super.validate(userRegistrationForm);

		if (userRegistrationForm.getUserName() != null) {
			UserEntity userByUserName = this.userRepository.findByUserName(userRegistrationForm.getUserName());
			if (userByUserName != null) {
				bindingResult.addError(new FieldError("userRegistrationForm", "userName", userRegistrationForm.getUserName(), false, null, null, "User Name must be be unique."));
			}
		}

		if (userRegistrationForm.getPassword() != null && userRegistrationForm.getConfirmPassword() != null) {
			if (!userRegistrationForm.getPassword().equals(userRegistrationForm.getConfirmPassword())) {
				bindingResult.addError(new FieldError("userRegistrationForm", "password", null, false, null, null, "Passwords must match."));
			}
		}

		return bindingResult;
	}

	@Override
	public UserEntity getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		return this.selectByUserName(authentication.getName());
	}

}
