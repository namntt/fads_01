package com.framgia.dao;

import java.util.List;

import com.framgia.model.News;

public interface NewsDAO extends BaseDAO<News, Integer> {
	List<News> findNewsByCategoryId(Integer category_id, Integer status);
}
