package com.framgia.dao;

import java.util.List;

import com.framgia.model.User;
import com.framgia.search.SearchUser;

public interface UserDAO {
	List<User> getUser(SearchUser searchUser);
	
}
