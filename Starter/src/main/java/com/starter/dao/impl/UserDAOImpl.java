package com.starter.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.repositories.UserRepository;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	@Autowired
	private UserRepository	userRepository;

	@Autowired
	private PasswordEncoder	passwordEncoder;

	@Override
	public List<UserEntity> select() {
		return this.userRepository.findAll();
	}

	@Override
	public Iterable<UserEntity> select(Sort sort) {
		return this.userRepository.findAll(sort);
	}

	@Override
	public Page<UserEntity> select(Pageable pageable) {
		return this.userRepository.findAll(pageable);
	}

	@Override
	public UserEntity selectById(UUID id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public UserEntity selectByUserName(String userName) {
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public UserEntity selectByForgotPasswordKey(String forgotPasswordKey) {
		return this.userRepository.findByForgotPasswordKey(forgotPasswordKey);
	}

	@Override
	public UserEntity newEntity() {
		return new UserEntity();
	}

	@Override
	public UserEntity create(Object form) {
		UserEntity user = new UserEntity();
		user.setCreatedAt(new Date());
		user.setCreatedBy(this.getCurrentUser());
		return this.update(user, form);
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
	public UserEntity update(UserEntity user, Object form) {
		if (form != null) {
			BeanUtils.copyProperties(form, user);
		}
		user.setUpdatedAt(new Date());
		user.setUpdatedBy(this.getCurrentUser());
		return this.userRepository.save(user);
	}

	@Override
	public void delete(UserEntity user) {
		this.userRepository.delete(user);
	}

	@Override
	public UserEntity getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_ANONYMOUS")) {
				return null;
			}
		}

		return this.selectByUserName(authentication.getName());
	}

	@Override
	public UserEntity login(String userName, String password) {
		UserEntity user = this.selectByUserName(userName);
		if (user == null) {
			return null;
		}

		boolean match = this.passwordEncoder.matches(password, user.getPassword());
		if (!match) {
			return null;
		}

		user.setLastLoggedInAt(new Date());
		return this.update(user, null);
	}
}
