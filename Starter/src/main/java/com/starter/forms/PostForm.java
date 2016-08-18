package com.starter.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostForm extends BaseForm {

	@NotNull(message = "Title is a required field.")
	@Size(max = 255)
	private String title;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// private String content;
	//
	// @Size(max = 255)
	// private String alias;
	//
	// private Date publishedAt;
	//
	// private UserEntity authoredBy;
	//
	// private List<CategoryEntity> categories;
	//
	// private List<CategoryEntity> tags;

}
