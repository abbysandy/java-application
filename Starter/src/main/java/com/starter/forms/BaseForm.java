package com.starter.forms;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public abstract class BaseForm {

	public void setProperty(String name, String value) {
		try {
			new PropertyDescriptor(name, this.getClass()).getWriteMethod().invoke(this, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
			e.printStackTrace();
		}
	}

}
