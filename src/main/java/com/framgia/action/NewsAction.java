package com.framgia.action;

import com.framgia.model.News;
import com.framgia.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private NewsService newsService;
	private News news;
	private Integer id;

	public String findByNewId() {
		news = newsService.findById(id);
		return SUCCESS;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
