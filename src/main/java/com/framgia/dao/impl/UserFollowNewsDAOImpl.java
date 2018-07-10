package com.framgia.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
		return getSession().createQuery(cr.select(root)).uniqueResult();
	}

}
