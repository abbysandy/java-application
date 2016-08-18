package com.starter.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.starter.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryEntity, UUID> {

}
