package com.framgia.service;

import java.util.List;
import com.framgia.model.User;
import com.framgia.search.Search;
import com.framgia.search.SearchUser;

public interface UserService {
	List<User> findAll();
	
	User findById(Integer id);
}
