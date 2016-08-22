package com.starter.dao;

import com.starter.entities.UserEntity;

public interface UserDAO extends BaseCrudDAO<UserEntity> {

	UserEntity getCurrentUser();

	UserEntity selectByUserName(String userName);

	UserEntity selectByForgotPasswordKey(String forgotPasswordKey);

	UserEntity login(String userName, String password);

}
