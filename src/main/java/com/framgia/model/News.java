package com.framgia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Category category;
	private City city;
	private String tittle;
	private String content;
	private String phoneNumber;
	private Integer status;
	private Date startDate;
	private Date endDate;
	private Date createDate;
	private User user;
	private Double price;
	private List<UserFollowNews> userFollowNewses;
	private List<Comment> comments;
	private List<NewsImage> newsImages;

	public News() {
	}

	public News(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<UserFollowNews> getUserFollowNewses() {
		return userFollowNewses;
	}

	public void setUserFollowNewses(List<UserFollowNews> userFollowNewses) {
		this.userFollowNewses = userFollowNewses;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<NewsImage> getNewsImages() {
		return newsImages;
	}

	public void setNewsImages(List<NewsImage> newsImages) {
		this.newsImages = newsImages;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
