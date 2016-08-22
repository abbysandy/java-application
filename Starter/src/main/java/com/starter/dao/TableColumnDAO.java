package com.starter.dao;

import com.starter.entities.TableColumnEntity;
import com.starter.entities.UserEntity;

public interface TableColumnDAO {

	Iterable<TableColumnEntity> selectByUserAndSection(UserEntity user, String section);

	TableColumnEntity save(TableColumnEntity tableColumnEntity);

	void deleteByUserAndSection(UserEntity user, String section);

}
