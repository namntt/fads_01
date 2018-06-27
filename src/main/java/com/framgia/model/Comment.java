package com.framgia.model;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private News news;
	private User userAccount;
	private Date createdDate;
	private String description;
	private Integer parentId;

	public Comment() {
	}

	public Comment(News news, User userAccount, Date createdDate, String description, Integer parentId) {
		this.news = news;
		this.userAccount = userAccount;
		this.createdDate = createdDate;
		this.description = description;
		this.parentId = parentId;
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

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
