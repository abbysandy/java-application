package com.starter.repositories;

import org.springframework.stereotype.Repository;

import com.starter.entities.UserEntity;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Integer> {

	public UserEntity findByUserName(String username);

}
