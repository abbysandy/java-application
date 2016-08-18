package com.starter.forms;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.starter.entities.CategoryEntity;
import com.starter.entities.TagEntity;
import com.starter.entities.UserEntity;

public class PostForm extends BaseForm {

	@NotNull(message = "Title is a required field.")
	@Size(max = 255)
	private String					title;

	private String					content;

	@Size(max = 255)
	private String					alias;

	private Date					publishedAt;

	private UserEntity				authoredBy;

	private List<CategoryEntity>	categories;

	private List<TagEntity>			tags;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getPublishedAt() {
		return this.publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public UserEntity getAuthoredBy() {
		return this.authoredBy;
	}

	public void setAuthoredBy(UserEntity authoredBy) {
		this.authoredBy = authoredBy;
	}

	public List<CategoryEntity> getCategories() {
		return this.categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public List<TagEntity> getTags() {
		return this.tags;
	}

	public void setTags(List<TagEntity> tags) {
		this.tags = tags;
	}

}
