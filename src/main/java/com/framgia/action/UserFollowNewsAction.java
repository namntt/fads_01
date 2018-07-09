package com.framgia.action;

import com.framgia.model.News;
import com.framgia.model.User;
import com.framgia.model.UserFollowNews;

public class UserFollowNewsAction extends BaseAction {
	private Integer newsId;
	private Integer id;
	private UserFollowNews userFollowNews;

	public String create() {
		User user = (User) getSessionAttributes().get("USER");
		userFollowNews = userFollowNewsService.getByUserIdAndNewsId(user.getId(), newsId);
		if (userFollowNews != null) {
			userFollowNewsService.removeUserFollowNews(userFollowNews);
		} else {
			userFollowNews = new UserFollowNews(new News(newsId), new User(user.getId()));
			userFollowNews = userFollowNewsService.createFollow(userFollowNews);
		}
		return "success";
	}

	public UserFollowNews getUserFollowNews() {
		return userFollowNews;
	}

	public void setUserFollowNews(UserFollowNews userFollowNews) {
		this.userFollowNews = userFollowNews;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
