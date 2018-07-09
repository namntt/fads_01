package com.framgia.service.impl;

import java.util.List;

import com.framgia.dao.UserFollowNewsDAO;
import com.framgia.model.UserFollowNews;
import com.framgia.service.UserFollowNewsService;

public class UserFollowNewsServiceImpl implements UserFollowNewsService {
	private UserFollowNewsDAO userFollowNewsDAO;

	public UserFollowNewsDAO getUserFollowNewsDAO() {
		return userFollowNewsDAO;
	}

	public void setUserFollowNewsDAO(UserFollowNewsDAO userFollowNewsDAO) {
		this.userFollowNewsDAO = userFollowNewsDAO;
	}

	@Override
	public UserFollowNews createFollow(UserFollowNews userFollowNews) {
		try {
			return getUserFollowNewsDAO().saveOrUpdate(userFollowNews);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<UserFollowNews> getAll() {
		try {
			return getUserFollowNewsDAO().findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UserFollowNews getByUserIdAndNewsId(Integer userId, Integer newsId) {
		try {
			return getUserFollowNewsDAO().findByUserIdAndNewsId(userId, newsId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void removeUserFollowNews(UserFollowNews userFollowNews) {
		try {
			getUserFollowNewsDAO().delete(userFollowNews);
		} catch (Exception e) {
			throw e;
		}
	}

}
