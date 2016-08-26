package com.starter.dao;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.starter.entities.RoleEntity;
import com.starter.entities.UserEntity;

public interface UserDAO extends BaseCrudDAO<UserEntity> {

	UserEntity getCurrentUser();

	UserEntity selectByUserName(String userName);

	UserEntity selectByForgotPasswordKey(String forgotPasswordKey);

	UserEntity login(String userName, String password);

	List<? extends GrantedAuthority> getAuthorities(List<RoleEntity> roles);

}
