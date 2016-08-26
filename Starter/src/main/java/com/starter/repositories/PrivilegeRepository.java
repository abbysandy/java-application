package com.starter.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.starter.entities.PrivilegeEntity;

@Repository
public interface PrivilegeRepository extends BaseRepository<PrivilegeEntity, UUID> {

}
