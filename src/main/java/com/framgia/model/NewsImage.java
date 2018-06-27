package com.framgia.model;

import java.io.Serializable;

public class NewsImage implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private News news;
	private String name;
	private String path;

	public NewsImage() {
	}

	public NewsImage(News news, String name, String path) {
		this.news = news;
		this.name = name;
		this.path = path;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
