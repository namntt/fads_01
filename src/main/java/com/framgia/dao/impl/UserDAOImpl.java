package com.framgia.dao.impl;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;

public class UserDAOImpl extends GenericDAOAbstract<User, Integer> implements UserDAO {

	@Override
	public User findByUsenameAndPassword(String username, String password) {

		return (User) getSession().createQuery("from User where username=:username and password=:password")
				.setParameter("username", username).setParameter("password", password).getSingleResult();
	}
}
