package com.framgia.dao;

import java.util.List;

import com.framgia.model.UserFollowNews;

public interface UserFollowNewsDAO extends BaseDAO<UserFollowNews, Integer> {
	UserFollowNews findByUserIdAndNewsId(Integer userId, Integer newsId);

	List<Integer> findQuantityUserFollowNews();

	List<Integer> findAllByUserId(Integer userId);
}
