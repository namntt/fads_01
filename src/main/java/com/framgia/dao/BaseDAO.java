package com.framgia.dao;

import java.util.List;

public interface BaseDAO<T,PK> {
	
	public List<T> findAll();

}
