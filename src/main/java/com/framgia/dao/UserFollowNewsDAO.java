package com.framgia.dao;

import com.framgia.model.UserFollowNews;

public interface UserFollowNewsDAO extends BaseDAO<UserFollowNews, Integer>{
	UserFollowNews findByUserIdAndNewsId(Integer userId,Integer newsId);
}
