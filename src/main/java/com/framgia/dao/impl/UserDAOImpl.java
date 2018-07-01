package com.framgia.dao.impl;

import org.hibernate.SessionFactory;
import com.framgia.dao.UserDAO;
import com.framgia.model.User;

public class UserDAOImpl extends GenericDAOAbstract<User, Integer> implements UserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findByUsenameAndPassword(String username, String password) {
		return (User) getSessionFactory().getCurrentSession()
				.createQuery("from User where username=:username and password=:password")
				.setParameter("username", username).setParameter("password", password).getSingleResult();
	}
}
