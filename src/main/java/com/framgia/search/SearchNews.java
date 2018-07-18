package com.framgia.search;

import com.framgia.model.City;
import com.framgia.model.News;

public class SearchNews extends Search<News> {
	private static final long serialVersionUID = 1L;

	public SearchNews() {
		super();
		this.setFieldsSearch(new News());
		this.getFieldsSearch().setCity(new City());
	}

}
