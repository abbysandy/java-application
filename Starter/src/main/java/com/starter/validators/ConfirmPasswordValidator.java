package com.starter.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.starter.forms.UserPasswordForm;

@Component
public class ConfirmPasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserPasswordForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserPasswordForm userPasswordForm = (UserPasswordForm) target;
		String password = userPasswordForm.getPassword();
		String confirmPassword = userPasswordForm.getConfirmPassword();

		if (password != null && confirmPassword != null) {
			if (!password.equals(confirmPassword)) {
				errors.rejectValue("password", null, "Passwords must match.");
			}
		}

	}

}
