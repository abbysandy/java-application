package com.starter.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

	@Column
	private String	userName;

	@Column
	private String	password;

	@Column
	private String	firstName;

	@Column
	private String	middleName;

	@Column
	private String	lastName;

	@Column
	private String	emailAddress;

	@Column
	private String	phone;

	@Column
	private String	address;

	@Column
	private String	city;

	@Column
	private String	state;

	@Column
	private String	zipCode;

	@Column
	private String	country;

	@Column
	private boolean	enabled;

	@Column
	private String	forgotPasswordKey;

	@Column
	private Date	lastLoggedInAt;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getForgotPasswordKey() {
		return this.forgotPasswordKey;
	}

	public void setForgotPasswordKey(String forgotPasswordKey) {
		this.forgotPasswordKey = forgotPasswordKey;
	}

	public Date getLastLoggedInAt() {
		return this.lastLoggedInAt;
	}

	public void setLastLoggedInAt(Date lastLoggedInAt) {
		this.lastLoggedInAt = lastLoggedInAt;
	}

	public String getFullName() {
		return String.format("%s %s", this.firstName, this.lastName);
	}

}
