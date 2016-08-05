package com.starter.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

public class BaseDAOImpl {

	@Autowired
	private Validator validator;

	public BindingResult validate(Object form) {
		DataBinder binder = new DataBinder(form);
		binder.setValidator(this.validator);
		binder.validate();
		return binder.getBindingResult();
	}

}
