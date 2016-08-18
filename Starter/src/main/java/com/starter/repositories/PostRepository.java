package com.starter.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.starter.entities.PostEntity;

@Repository
public interface PostRepository extends BaseRepository<PostEntity, UUID> {

	public PostEntity findByAlias(String alias);

}
