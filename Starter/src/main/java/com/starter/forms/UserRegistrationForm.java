package com.starter.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationForm extends BaseForm {

	@NotNull(message = "User Name is a required field.")
	@Size(max = 255)
	private String	userName;

	@NotNull(message = "First Name is a required field.")
	@Size(max = 255)
	private String	firstName;

	@NotNull(message = "Last Name is a required field.")
	@Size(max = 255)
	private String	lastName;

	@NotNull(message = "Email Address is a required field.")
	@Size(max = 255)
	private String	emailAddress;

	@NotNull(message = "Password is a required field.")
	private String	password;

	@NotNull(message = "Confirm Password is a required field.")
	private String	confirmPassword;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

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
