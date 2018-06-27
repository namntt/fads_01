package com.framgia.model;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Role role;
	private User userAccount;
	private Integer status;

	public UserRole() {
	}

	public UserRole(Role role, User userAccount) {
		this.role = role;
		this.userAccount = userAccount;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
