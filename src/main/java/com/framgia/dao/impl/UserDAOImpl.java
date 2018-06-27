package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.search.SearchUser;

public class UserDAOImpl implements UserDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getUser(SearchUser searchUser) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = builder.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		if (StringUtils.isNotBlank(searchUser.getKeyword())) {
			cr.where(builder.like(builder.lower(root.get("username")), "%" + searchUser.getKeyword() + "%"));
		}
		TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery(cr.select(root));
		typedQuery.setFirstResult((searchUser.getPage() - 1) * searchUser.getPageSize());
		typedQuery.setMaxResults(searchUser.getPageSize());
		cr.orderBy(builder.asc(root.get("id")));
		return typedQuery.getResultList();
	}

}
