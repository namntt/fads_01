package com.framgia.service;

import java.util.List;

import com.framgia.model.UserFollowNews;

public interface UserFollowNewsService {
	UserFollowNews createFollow(UserFollowNews userFollowNews);

	List<UserFollowNews> loadAll();

	UserFollowNews loadByUserIdAndNewsId(Integer userId, Integer newsId);

	void removeUserFollowNews(UserFollowNews userFollowNews);
	
	List<Integer> loadQuantityUserFollowNews();
}
