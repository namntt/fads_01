package com.framgia.action;

import com.framgia.model.News;
import com.framgia.model.User;
import com.framgia.model.UserFollowNews;

public class NewsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private News news;
	private Integer id;
	private UserFollowNews userFollowNews;

	public String index() {
		return "success";
	}

	public String showDetailNews() {
		User user = (User) getSessionAttributes().get("USER");
		news = newsService.findById(id);
		userFollowNews = userFollowNewsService.loadByUserIdAndNewsId(user.getId(), id);
		return "success";
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserFollowNews getUserFollowNews() {
		return userFollowNews;
	}

	public void setUserFollowNews(UserFollowNews userFollowNews) {
		this.userFollowNews = userFollowNews;
	}
}
