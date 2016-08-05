package com.starter.forms;

import javax.validation.constraints.NotNull;

public class UserPasswordForm {

	@NotNull(message = "Password is a required field.")
	private String	password;

	@NotNull(message = "Confirm Password is a required field.")
	private String	confirmPassword;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
