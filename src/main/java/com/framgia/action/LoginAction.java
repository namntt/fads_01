package com.framgia.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.framgia.model.User;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private UserService userService;
	private Map<String, Object> sessionAttributes;

	private String username;
	private String password;
	private User user;

	@Override
	public String execute() {
		user = userService.findByUsenameAndPassword(username, password);
		if (user == null) {
			return INPUT;
		}
		this.sessionAttributes.put("USER", user);
		return SUCCESS;
	}

	public void validate() {
		if (StringUtils.isEmpty(username)) {
			addFieldError("username", getText("username.required"));
		}
		if (StringUtils.isEmpty(password)) {
			addFieldError("password", getText("password.required"));
		}
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
