package com.framgia.action;

import java.util.List;

import com.framgia.model.Category;
import com.framgia.model.News;
import com.framgia.service.CategoryService;
import com.framgia.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Category category;
	private List<Category> categories;
	private CategoryService categoryService;
	private NewsService newsService;
	private List<News> subCategory;
	private Integer id;

	public String index() {
		categories = categoryService.findAll();
		return SUCCESS;
	}

	public String getNews() {
		subCategory = newsService.findNewsByCategoryId(id, 1);
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<News> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<News> subCategory) {
		this.subCategory = subCategory;
	}

}
