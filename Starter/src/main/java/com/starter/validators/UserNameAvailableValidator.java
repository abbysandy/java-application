package com.starter.validators;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;

@Component
public class UserNameAvailableValidator implements Validator {

	@Autowired
	UserDAO userDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm userForm = (UserForm) target;
		String userName = userForm.getUserName();
		UUID id = userForm.getId();

		if (userName != null && !StringUtils.isEmpty(userName)) {
			UserEntity userByUserName = this.userDAO.selectByUserName(userName);

			if (userByUserName != null && (id == null || !id.equals(userByUserName.getId()))) {
				errors.rejectValue("userName", null, "User Name must be be unique.");
			}
		}
	}

}
