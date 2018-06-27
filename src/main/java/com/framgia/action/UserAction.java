package com.framgia.action;

import java.util.List;
import com.framgia.model.User;
import com.framgia.search.SearchUser;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private List<User> users;
	private User user;
	private String searchKeyword;
	
	public String listUser() {
		SearchUser searchUser = new SearchUser();
		searchUser.setKeyword(getSearchKeyword());
		users = userService.getUser(searchUser);
		return SUCCESS;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
}
