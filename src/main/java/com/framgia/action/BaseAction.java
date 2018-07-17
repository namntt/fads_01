package com.framgia.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.framgia.model.User;
import com.framgia.service.CategoryService;
import com.framgia.service.CityService;
import com.framgia.service.CommentService;
import com.framgia.service.NewsImageService;
import com.framgia.service.NewsService;
import com.framgia.service.UserFollowNewsService;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import common.UserCustomFile;

public class BaseAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	protected CategoryService categoryService;
	protected NewsService newsService;
	protected CityService cityService;
	protected UserService userService;
	protected NewsImageService newsImageService;
	protected UserFollowNewsService userFollowNewsService;
	protected CommentService commentService;
	protected Map<String, Object> sessionAttributes;
	private User currentUser;
	private List<File> myFiles;
	private List<String> myFilesFileName;
	private List<String> myFilesContentType;

	public void setCurrentUser(User currentUser) {
		try {
			currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		} catch (Exception e) {
		}
	}

	public List<String> getMyFilesContentType() {
		return myFilesContentType;
	}

	public void setMyFilesContentType(List<String> myFilesContentType) {
		this.myFilesContentType = myFilesContentType;
	}

	public List<String> getMyFilesFileName() {
		return myFilesFileName;
	}

	public void setMyFilesFileName(List<String> myFilesFileName) {
		this.myFilesFileName = myFilesFileName;
	}

	public List<File> getMyFiles() {
		return myFiles;
	}

	public boolean saveFiles() {
		try {
			for (int i = 0; i < myFiles.size(); i++) {

				UserCustomFile.saveFileLocal(myFiles.get(i), myFilesFileName.get(i));

			}
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public void setMyFiles(List<File> myFiles) {
		this.myFiles = myFiles;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public NewsImageService getNewsImageService() {
		return newsImageService;
	}

	public void setNewsImageService(NewsImageService newsImageService) {
		this.newsImageService = newsImageService;
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

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionAttributes = session;
	}
}
