package com.starter.tables;

public class UserTableColumns {

	private boolean	userName		= true;

	private boolean	firstName		= true;

	private boolean	middleName		= false;

	private boolean	lastName		= true;

	private boolean	emailAddress	= true;

	private boolean	phone			= false;

	private boolean	address			= true;

	private boolean	city			= true;

	private boolean	state			= true;

	private boolean	zipCode			= true;

	private boolean	country			= false;

	public boolean isUserName() {
		return this.userName;
	}

	public void setUserName(boolean userName) {
		this.userName = userName;
	}

	public boolean isFirstName() {
		return this.firstName;
	}

	public void setFirstName(boolean firstName) {
		this.firstName = firstName;
	}

	public boolean isMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(boolean middleName) {
		this.middleName = middleName;
	}

	public boolean isLastName() {
		return this.lastName;
	}

	public void setLastName(boolean lastName) {
		this.lastName = lastName;
	}

	public boolean isEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(boolean emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isPhone() {
		return this.phone;
	}

	public void setPhone(boolean phone) {
		this.phone = phone;
	}

	public boolean isAddress() {
		return this.address;
	}

	public void setAddress(boolean address) {
		this.address = address;
	}

	public boolean isCity() {
		return this.city;
	}

	public void setCity(boolean city) {
		this.city = city;
	}

	public boolean isState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isZipCode() {
		return this.zipCode;
	}

	public void setZipCode(boolean zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isCountry() {
		return this.country;
	}

	public void setCountry(boolean country) {
		this.country = country;
	}

}
