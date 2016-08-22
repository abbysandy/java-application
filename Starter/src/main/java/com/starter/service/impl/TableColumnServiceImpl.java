package com.starter.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.dao.TableColumnDAO;
import com.starter.dao.UserDAO;
import com.starter.entities.TableColumnEntity;
import com.starter.entities.UserEntity;
import com.starter.service.TableColumnService;

@Service
public class TableColumnServiceImpl implements TableColumnService {

	@Autowired
	private UserDAO			userDAO;

	@Autowired
	private TableColumnDAO	tableColumnDAO;

	@Override
	public <T> T load(Class<T> clazz, String section) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		return this.load(clazz, this.userDAO.getCurrentUser(), section);
	}

	@Override
	public <T> T load(Class<T> clazz, UserEntity user, String section) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		T newInstance = clazz.newInstance();

		Iterable<TableColumnEntity> tableColumns = this.tableColumnDAO.selectByUserAndSection(user, section);

		for (TableColumnEntity tableColumn : tableColumns) {
			BeanUtils.setProperty(newInstance, tableColumn.getName(), tableColumn.isVisible());
		}

		return newInstance;
	}

	@Override
	public <T> void save(Class<T> clazz, Object form, String section) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		this.save(clazz, form, this.userDAO.getCurrentUser(), section);
	}

	@Override
	public <T> void save(Class<T> clazz, Object form, UserEntity user, String section) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		this.tableColumnDAO.deleteByUserAndSection(user, section);

		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {

			boolean visible = Boolean.parseBoolean(BeanUtils.getProperty(form, field.getName()));

			TableColumnEntity tableColumn = new TableColumnEntity();
			tableColumn.setSection(section);
			tableColumn.setName(field.getName());
			tableColumn.setVisible(visible);
			tableColumn.setUser(user);
			tableColumn.setCreatedAt(new Date());
			this.tableColumnDAO.save(tableColumn);

		}

	}

}
