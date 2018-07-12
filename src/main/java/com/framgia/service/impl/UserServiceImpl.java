package com.framgia.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.service.UserService;

public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> findAll() {
		try {
			return getUserDAO().findAll();
		} catch (Exception e) {
			LOGGER.info("find all user fail !");
			return null;
		}
	}

	@Override
	public User findByUsenameAndPassword(String username, String password) {
		try {
			return userDAO.findByUsenameAndPassword(username, password);
		} catch (Exception e) {
			LOGGER.info("---> Error find username and password");
			return null;
		}
	}

	@Override
	public User findById(Integer id) {
		try {
			LOGGER.info("Find user successful");
			return getUserDAO().findBy("id", id);
		} catch (Exception e) {
			LOGGER.error("User not exist", e);
			return null;
		}
	}

	@Override
	public User addUser(User user) {
		try {
			if (user.getCreatedDate() == null) {
				user.setCreatedDate(new Date());
			}
			LOGGER.info("add user successful");
			return getUserDAO().saveOrUpdate(user);
		} catch (Exception e) {
			LOGGER.error("add user fail", e);
			throw e;
		}
	}

	@Override
	public User updateUser(User user) {
		try {
			return getUserDAO().saveOrUpdate(user);
		} catch (Exception e) {
			LOGGER.error("Update user fail", e);
			throw e;
		}
	}

	@Override
	public User findByUsername(String username) {
		try {
			return userDAO.findBy("username", username);
		} catch (Exception e) {
			LOGGER.error("Khong tim thay user");
			return null;
		}
	}
}
