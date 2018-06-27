package com.framgia.model;

import java.io.Serializable;

public class UserFollowNews implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private News news;
	private User userAccount;
	private Integer status;

	public UserFollowNews() {
	}

	public UserFollowNews(News news, User userAccount, Integer status) {
		this.news = news;
		this.userAccount = userAccount;
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public User getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
