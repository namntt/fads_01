package com.framgia.service.impl;

import java.util.List;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.search.SearchUser;
import com.framgia.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	@Override
	public List<User> getUser(SearchUser searchUser) {
		return getUserDAO().getUser(searchUser);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	
}
