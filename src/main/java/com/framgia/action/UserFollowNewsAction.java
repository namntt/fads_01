package com.framgia.action;

import java.util.ArrayList;
import java.util.List;

import com.framgia.model.News;
import com.framgia.model.User;
import com.framgia.model.UserFollowNews;

public class UserFollowNewsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer newsId;
	private Integer id;
	private UserFollowNews userFollowNews;
	private List<News> newses;
	private List<UserFollowNews> userFollowNewses;
	private List<Integer> newsIds;

	public String followOrUnfollowNews() {
		userFollowNews = userFollowNewsService.loadByUserIdAndNewsId(getCurrentUser().getId(), newsId);
		if (userFollowNews != null) {
			userFollowNewsService.removeUserFollowNews(userFollowNews);
		} else {
			userFollowNews = new UserFollowNews(new News(newsId), new User(getCurrentUser().getId()));
			userFollowNews = userFollowNewsService.createFollow(userFollowNews);
		}
		return SUCCESS;
	}

	public String showMyFavorite() {
		newsIds = userFollowNewsService.loadFavoriteNewses(getCurrentUser().getId());
		newses = new ArrayList<>();
		newsIds.forEach(news_ids -> newses.add(newsService.findById(news_ids)));
		return SUCCESS;
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

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

	public List<UserFollowNews> getUserFollowNewses() {
		return userFollowNewses;
	}

	public void setUserFollowNewses(List<UserFollowNews> userFollowNewses) {
		this.userFollowNewses = userFollowNewses;
	}

	public List<Integer> getNewsIds() {
		return newsIds;
	}

	public void setNewsIds(List<Integer> newsIds) {
		this.newsIds = newsIds;
	}

}
