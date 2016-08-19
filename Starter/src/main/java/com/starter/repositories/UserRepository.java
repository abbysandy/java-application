package com.starter.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.starter.entities.UserEntity;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, UUID> {

	public UserEntity findByUserName(String username);

	public UserEntity findByForgotPasswordKey(String forgotPasswordKey);

}
