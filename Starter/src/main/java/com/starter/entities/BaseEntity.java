package com.starter.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID		id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity	createdBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity	updatedBy;

	@Column
	private Date		createdAt;

	@Column
	private Date		updatedAt;

	@Override
	public String toString() {
		return this.id.toString();
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UserEntity getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public UserEntity getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(UserEntity updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
