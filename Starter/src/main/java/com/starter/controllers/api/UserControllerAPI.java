package com.starter.controllers.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starter.dao.TableColumnDAO;
import com.starter.dao.UserDAO;
import com.starter.entities.TableColumnEntity;
import com.starter.entities.UserEntity;
import com.starter.forms.ListMapForm;
import com.starter.forms.UserForm;
import com.starter.validators.UserNameAvailableValidator;

@Controller
public class UserControllerAPI extends BaseControllerAPI {

	@Autowired
	private UserDAO						userDAO;

	@Autowired
	private TableColumnDAO				tableColumnDAO;

	@Autowired
	private UserNameAvailableValidator	userNameAvailableValidator;

	@ResponseBody
	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PATCH)
	public Map<String, Object> updateUser(@PathVariable UUID id, HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		Map<String, Object> result = new HashMap<>();

		UserEntity user = this.userDAO.selectById(id);
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

		DataBinder binder = new DataBinder(userForm);
		binder.setValidator(this.userNameAvailableValidator);
		binder.validate();
		BindingResult binding = binder.getBindingResult();

		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			result.put("errors", binding.getFieldErrors());
			return result;
		}

		this.userDAO.update(user, userForm);

		result.put("user", user);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/api/users/user-table-columns", method = RequestMethod.PUT)
	public Map<String, Object> updateTableColumns(HttpServletResponse response, ListMapForm listMapForm, HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, String>> fields = listMapForm.getFields();

		if (fields == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			result.put("message", "invalid parameters");
			return result;
		}

		UserEntity user = this.userDAO.getCurrentUser();
		this.tableColumnDAO.deleteByUserAndSection(user, "users");

		for (Map<String, String> map : fields) {

			String name = map.get("name");
			Boolean visible = Boolean.valueOf(map.get("visible"));

			if (name == null || name.isEmpty() || visible == null) {
				continue;
			}

			TableColumnEntity tableColumnEntity = new TableColumnEntity();
			tableColumnEntity.setSection("users");
			tableColumnEntity.setName(name);
			tableColumnEntity.setVisible(visible);
			tableColumnEntity.setUser(user);
			tableColumnEntity.setCreatedAt(new Date());
			this.tableColumnDAO.save(tableColumnEntity);
		}

		result.put("fields", fields);

		return result;
	}

}
