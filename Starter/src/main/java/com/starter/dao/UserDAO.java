package com.starter.dao;

import org.springframework.validation.BindingResult;

import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.forms.UserPasswordForm;
import com.starter.forms.UserRegistrationForm;

public interface UserDAO extends BaseDAO<UserEntity> {

	UserEntity getCurrentUser();

	UserEntity selectByUserName(String userName);

	BindingResult validate(UserEntity user, UserForm userForm);

	BindingResult validate(UserPasswordForm userPasswordForm);

	BindingResult validate(UserRegistrationForm userRegistrationForm);

}
