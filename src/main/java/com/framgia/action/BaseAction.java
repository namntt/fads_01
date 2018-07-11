package com.framgia.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.framgia.model.User;
import com.framgia.service.CategoryService;
import com.framgia.service.CityService;
import com.framgia.service.NewsService;
import com.framgia.service.UserFollowNewsService;
import com.framgia.service.UserService;

public class BaseAction implements SessionAware {
	protected CategoryService categoryService;
	protected NewsService newsService;
	protected CityService cityService;
	protected UserService userService;
	protected UserFollowNewsService userFollowNewsService;
	protected Map<String, Object> sessionAttributes;
	private User currentUser;

	public User getCurrentUser() {
		this.currentUser = (User) getSessionAttributes().get("USER");
		return currentUser;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public void setUserFollowNewsService(UserFollowNewsService userFollowNewsService) {
		this.userFollowNewsService = userFollowNewsService;
	}

	public Map<String, Object> getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionAttributes = session;
	}

}
