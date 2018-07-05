package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.NewsDAO;
import com.framgia.model.News;
import com.framgia.search.Search;
import com.framgia.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private NewsDAO newsDAO;

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	public List<News> findNewsByCategoryId(Integer category_id, Integer status, Search<News> searchNew) {
		try {
			LOGGER.info("List news by category");
			return getNewsDAO().findNewsByCategoryId(category_id, status, searchNew);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public News findById(Integer id) {
		try {
			LOGGER.info("Find by new id");
			return getNewsDAO().findBy("id", id);
		} catch (Exception e) {
			return null;
		}
	}
}
