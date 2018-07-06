package com.framgia.dao;

import java.io.Serializable;
import java.util.List;

import com.framgia.search.Search;

public interface BaseDAO<T,PK> {
	
	public List<T> findAll();
	
	public T findBy(String atribute, Serializable key);
	
	public T saveOrUpdate(T entity);

}
