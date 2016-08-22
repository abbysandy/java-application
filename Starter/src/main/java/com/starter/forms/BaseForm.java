package com.starter.forms;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public abstract class BaseForm {

	public void setProperty(String name, String value) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.setProperty(this, name, value);
	}

}
