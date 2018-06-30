package com.framgia.search;

import java.io.Serializable;

public class Search<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private T fieldsSearch;
	private Integer page;
	private Integer pageSize;
	private Integer totalPage;
	
	public Search() {
		this.pageSize=10;
		this.page=1;
	}
	
	public T getFieldsSearch() {
		return fieldsSearch;
	}

	public void setFieldsSearch(T fieldsSearch) {
		this.fieldsSearch = fieldsSearch;
	}

	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
