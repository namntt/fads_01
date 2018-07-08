package com.framgia.search;

import com.framgia.model.City;
import com.framgia.model.News;

public class SearchNews extends Search<News> {
	private static final long serialVersionUID = 1L;
	private Integer city_id;

	public SearchNews() {
		super();
		this.setFieldsSearch(new News());
		this.getFieldsSearch().setCity(new City());
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

}
