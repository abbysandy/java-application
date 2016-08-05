package com.starter.controllers.api;

import javax.servlet.http.HttpServletRequest;

import com.starter.controllers.BaseController;

public class BaseControllerAPI extends BaseController {

	public String getParameter(HttpServletRequest request, String name) {
		String value = request.getParameter(name);

		if (value.trim().isEmpty()) {
			return null;
		}

		return value;
	}

}
