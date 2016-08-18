package com.starter.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.starter.entities.TagEntity;

@Repository
public interface TagRepository extends BaseRepository<TagEntity, UUID> {

}
