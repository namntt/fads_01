package com.framgia.search;

import com.framgia.model.City;

public class SearchCity extends Search<City> {

	private static final long serialVersionUID = 1L;

	public SearchCity() {
		super();
		this.setFieldsSearch(new City());
	}

}
