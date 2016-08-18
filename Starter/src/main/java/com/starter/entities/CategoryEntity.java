package com.starter.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Column
	private String				name;

	@ManyToMany
	private List<PostEntity>	posts;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PostEntity> getPosts() {
		return this.posts;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}

}
