package com.starter.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {

	@Column
	private String					title;

	@Column
	private String					content;

	@Column
	private String					alias;

	@Column
	private Date					publishedAt;

	@ManyToOne
	private UserEntity				authoredBy;

	@ManyToMany
	@JoinTable(name = "posts_categories", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	private List<CategoryEntity>	categories;

	@ManyToMany
	@JoinTable(name = "posts_tags", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
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
