package com.starter.service;

import com.starter.entities.UserEntity;

public interface TableColumnService {

	public <T> T load(Class<T> clazz, String section) throws Exception;

	public <T> T load(Class<T> clazz, UserEntity user, String section) throws Exception;

	public <T> void save(Class<T> clazz, Object form, String section) throws Exception;

	public <T> void save(Class<T> clazz, Object form, UserEntity user, String section) throws Exception;

}
