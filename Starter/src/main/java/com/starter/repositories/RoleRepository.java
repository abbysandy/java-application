package com.starter.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.starter.entities.RoleEntity;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity, UUID> {

	public RoleEntity findByName(String name);

}
