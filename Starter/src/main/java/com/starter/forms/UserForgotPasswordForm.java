package com.starter.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForgotPasswordForm extends BaseForm {

	@NotNull(message = "User Name is a required field.")
	@Size(max = 255)
	private String userName;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
