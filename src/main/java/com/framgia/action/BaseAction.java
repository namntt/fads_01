package com.framgia.action;

import com.framgia.service.CategoryService;
import com.framgia.service.CityService;
import com.framgia.service.NewsService;

public class BaseAction {
	protected CategoryService categoryService;
	protected NewsService newsService;
	protected CityService cityService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

}
