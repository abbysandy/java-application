package com.starter.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starter.dao.TableColumnDAO;
import com.starter.entities.TableColumnEntity;
import com.starter.entities.UserEntity;
import com.starter.repositories.TableColumnRepository;

@Repository
public class TableColumnDAOImpl implements TableColumnDAO {

	@Autowired
	private TableColumnRepository tableColumnRepository;

	@Override
	public Iterable<TableColumnEntity> selectByUserAndSection(UserEntity user, String section) {
		return this.tableColumnRepository.findByUserAndSection(user, section);
	}

	@Override
	public TableColumnEntity save(TableColumnEntity tableColumnEntity) {
		return this.tableColumnRepository.save(tableColumnEntity);
	}

	@Override
	public void deleteByUserAndSection(UserEntity user, String section) {
		Iterable<TableColumnEntity> tableColumns = this.tableColumnRepository.findByUserAndSection(user, section);
		for (TableColumnEntity tableColumn : tableColumns) {
			this.tableColumnRepository.delete(tableColumn);
		}
	}

}
