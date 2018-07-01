package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.service.UserService;

public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserDAO userDAO;

	@Override
	public List<User> findAll() {
		return getUserDAO().findAll();
	}

	@Override
	public User findByUsenameAndPassword(String username, String password) {
		User user = null;
		try {
			user = userDAO.findByUsenameAndPassword(username, password);
			LOGGER.info("---> find success username and password");
		} catch (Exception e) {
			LOGGER.info("---> Error find username and password");
		}
		return user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findById(Integer id) {
		try {
			User user = getUserDAO().findBy("id", id);
			return user;
		} catch (Exception e) {
		}
		return null;
	}
}
