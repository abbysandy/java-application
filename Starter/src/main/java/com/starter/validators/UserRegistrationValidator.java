package com.starter.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.starter.forms.UserForm;
import com.starter.forms.UserPasswordForm;
import com.starter.forms.UserRegistrationForm;

@Component
public class UserRegistrationValidator implements Validator {

	@Autowired
	private ConfirmPasswordValidator	confirmPasswordValidator;

	@Autowired
	private UserNameAvailableValidator	userNameAvailableValidator;

	@Override
	public boolean supports(Class<?> arg0) {
		return UserRegistrationForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserRegistrationForm userRegistrationForm = (UserRegistrationForm) target;

		UserForm userForm = new UserForm();
		userForm.setUserName(userRegistrationForm.getUserName());

		UserPasswordForm userPasswordForm = new UserPasswordForm();
		userPasswordForm.setPassword(userRegistrationForm.getPassword());
		userPasswordForm.setConfirmPassword(userRegistrationForm.getConfirmPassword());

		ValidationUtils.invokeValidator(this.confirmPasswordValidator, userPasswordForm, errors);
		ValidationUtils.invokeValidator(this.userNameAvailableValidator, userForm, errors);
	}

}
