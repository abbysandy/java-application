package com.starter.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForgotPasswordForm;

@Component
public class UserForgotPasswordValidator implements Validator {

	@Autowired
	UserDAO userDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForgotPasswordForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForgotPasswordForm userForgotPasswordForm = (UserForgotPasswordForm) target;

		String userName = userForgotPasswordForm.getUserName();
		if (userName == null) {
			return;
		}

		UserEntity selectByUserName = this.userDAO.selectByUserName(userName);
		if (selectByUserName == null) {
			errors.rejectValue("userName", null, "No account found for this user name.");
		}
	}

}
