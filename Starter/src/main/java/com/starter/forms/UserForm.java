package com.starter.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import com.starter.entities.UserEntity;

public class UserForm extends BaseForm {

	public UserForm() {
	}

	public UserForm(UserEntity userEntity) {
		BeanUtils.copyProperties(userEntity, this);
	}

	@NotNull
	@Size(max = 255)
	private String	username;

	@NotNull
	@Size(max = 255)
	private String	firstname;

	@Size(max = 255)
	private String	middlename;

	@NotNull
	@Size(max = 255)
	private String	lastname;

	@NotNull
	@Size(max = 255)
	private String	email;

	@Size(max = 255)
	private String	phone;

	@Size(max = 255)
	private String	address;

	@Size(max = 255)
	private String	city;

	@Size(max = 255)
	private String	state;

	@Size(max = 255)
	private String	zipcode;

	@Size(max = 255)
	private String	country;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
