package com.starter.dao;

import org.springframework.validation.BindingResult;

import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.forms.UserPasswordForm;

public interface UserDAO extends BaseDAO<UserEntity> {

	BindingResult validate(UserEntity user, UserForm userForm);

	BindingResult validate(UserPasswordForm userPasswordForm);

}
