package com.starter.controllers.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.repositories.UserRepository;

@Controller
public class UserControllerAPI extends BaseControllerAPI {

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PATCH)
	public Map<String, Object> updateUser(@PathVariable Integer id, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();

		UserEntity user = this.userRepository.findOne(id);
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			result.put("message", "invalid id");
			return result;
		}

		String name = this.getParameter(request, "name");
		String value = this.getParameter(request, "value");

		if (name == null || name.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			result.put("message", "invalid parameters");
			return result;
		}

		UserForm userForm = new UserForm();
		BeanUtils.copyProperties(user, userForm);
		userForm.setProperty(name, value);
		BindingResult bindingResult = this.validate(userForm);

		if (bindingResult.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			result.put("errors", bindingResult.getFieldErrors());
			return result;
		}

		BeanUtils.copyProperties(userForm, user);
		this.userRepository.save(user);

		result.put("user", user);
		return result;
	}

}
