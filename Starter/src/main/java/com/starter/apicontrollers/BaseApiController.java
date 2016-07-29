package com.starter.apicontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

public class BaseApiController {

	@Autowired
	private Validator validator;

	public BindingResult validate(Object form) {
		DataBinder binder = new DataBinder(form);
		binder.setValidator(this.validator);
		binder.validate();
		return binder.getBindingResult();
	}

	public String getParameter(HttpServletRequest request, String name) {
		String value = request.getParameter(name);

		if (value.trim().isEmpty()) {
			return null;
		}

		return value;
	}

}
