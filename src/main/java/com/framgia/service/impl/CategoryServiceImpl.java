package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.CategoryDAO;
import com.framgia.model.Category;
import com.framgia.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private CategoryDAO categoryDAO;
	@Override
	public List<Category> findAll() {
		LOGGER.info("List category");
		return getCategoryDAO().findAll();
	}
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
}
