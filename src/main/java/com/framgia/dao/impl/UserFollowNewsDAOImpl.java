package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.framgia.dao.UserFollowNewsDAO;
import com.framgia.model.News;
import com.framgia.model.User;
import com.framgia.model.UserFollowNews;

public class UserFollowNewsDAOImpl extends GenericDAOAbstract<UserFollowNews, Integer> implements UserFollowNewsDAO {

	@Override
	public UserFollowNews findByUserIdAndNewsId(Integer userId, Integer newsId) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<UserFollowNews> cr = builder.createQuery(UserFollowNews.class);
		Root<UserFollowNews> root = cr.from(UserFollowNews.class);
		Join<UserFollowNews, User> join_user = root.join("userAccount");
		Join<UserFollowNews, News> join_news = root.join("news");
		if (userId != null && newsId != null) {
			cr.where(builder.and(builder.equal(join_user.get("id"), userId),
					builder.equal(join_news.get("id"), newsId)));
		}
		return getSession().createQuery(cr.select(root)).getSingleResult();
	}

	@Override
	public List<Integer> findQuantityUserFollowNews() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Integer> cr = builder.createQuery(Integer.class);
		Root<UserFollowNews> root = cr.from(UserFollowNews.class);
		Join<UserFollowNews, News> join_news = root.join("news");
		Expression<Integer> groupByExp = join_news.get("id").as(Integer.class);
		Expression<Long> countExp = builder.count(groupByExp);
		cr.groupBy(groupByExp);
		cr.orderBy(builder.desc(countExp));
		CriteriaQuery<Integer> select = cr.multiselect(groupByExp);
		TypedQuery<Integer> typedQuery = getSession().createQuery(select);
		typedQuery.setMaxResults(5);
		return typedQuery.getResultList();
	}

	public List<Integer> findAllByUserId(Integer userId) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Integer> cr = builder.createQuery(Integer.class);
		Root<UserFollowNews> root = cr.from(UserFollowNews.class);
		Join<UserFollowNews, User> join_user = root.join("userAccount");
		Join<UserFollowNews, News> join_news = root.join("news");
		if (userId != null) {
			cr.where(builder.and(builder.equal(join_user.get("id"), userId)));
		}
		return getSession().createQuery(cr.select(join_news.get("id"))).getResultList();
	}

}
