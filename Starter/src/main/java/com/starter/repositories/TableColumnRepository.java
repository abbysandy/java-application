package com.starter.repositories;

import org.springframework.stereotype.Repository;

import com.starter.entities.TableColumnEntity;
import com.starter.entities.UserEntity;

@Repository
public interface TableColumnRepository extends BaseRepository<TableColumnEntity, Integer> {

	public Iterable<TableColumnEntity> findByUserAndSection(UserEntity user, String section);

}
