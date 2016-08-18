package com.starter.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TagForm extends BaseForm {

	@NotNull(message = "Name is a required field.")
	@Size(max = 255)
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
