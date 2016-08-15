package com.starter.forms;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm extends BaseForm {

	private UUID	id;

	@NotNull(message = "User Name is a required field.")
	@Size(max = 255)
	private String	userName;

	@NotNull(message = "First Name is a required field.")
	@Size(max = 255)
	private String	firstName;

	@Size(max = 255)
	private String	middleName;

	@NotNull(message = "Last Name is a required field.")
	@Size(max = 255)
	private String	lastName;

	@NotNull(message = "Email Address is a required field.")
	@Size(max = 255)
	private String	emailAddress;

	@Size(max = 255)
	private String	phone;

	@Size(max = 255)
	private String	address;

	@Size(max = 255)
	private String	city;

	@Size(max = 255)
	private String	state;

	@Size(max = 255)
	private String	zipCode;

	@Size(max = 255)
	private String	country;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
