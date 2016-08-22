package com.starter.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "table_columns")
public class TableColumnEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer		id;

	@ManyToOne
	@JsonIgnore
	private UserEntity	user;

	@Column
	private String		name;

	@Column
	private String		section;

	@Column
	private boolean		visible;

	@Column
	private Date		createdAt;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
