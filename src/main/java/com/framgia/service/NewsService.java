package com.framgia.service;

import java.util.List;

import com.framgia.model.News;

public interface NewsService {
	List<News> findNewsByCategoryId(Integer category_id,Integer status);
}
