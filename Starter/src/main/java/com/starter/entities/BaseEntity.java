package com.starter.entities;

import org.springframework.beans.BeanUtils;

public abstract class BaseEntity {

	public void load(Object form) {
		BeanUtils.copyProperties(form, this);
	}

}
