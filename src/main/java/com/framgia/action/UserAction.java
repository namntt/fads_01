package com.framgia.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.framgia.model.User;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private List<User> users;
	private User user;
	private String searchKeyword;
	private Integer id;
	private final String path = "/home/namnguyen/Desktop/upload/";
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String confirmPassword;

	public String changePasswordAction() {
		return SUCCESS;
	}

	public String index() {
		users = userService.findAll();
		if (users == null)
			return ERROR;
		return SUCCESS;
	}

	public String detail() {
		user = userService.findById(id);
		if (user == null)
			return ERROR;
		return SUCCESS;
	}

	public String newUser() {
		return SUCCESS;
	}

	public boolean saveFile() {
		boolean flag = true;
		try {
			File fileToCreate = new File(path, fileUploadFileName);
			FileUtils.copyFile(fileUpload, fileToCreate);
			user.setAvatar(fileUploadFileName);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public String addUser() {
		if (!saveFile() || !validUser())
			return INPUT;
		userService.addUser(user);
		return SUCCESS;
	}

	private boolean validUser() {
		if (StringUtils.isEmpty(user.getUsername())) {
			addFieldError("user.username", getText("users.username.required"));
			return false;
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			addFieldError("user.password", getText("users.password.required"));
			return false;
		}
		if (StringUtils.isEmpty(user.getBirthday().toString())) {
			addFieldError("user.birthday", getText("users.birthday.required"));
			return false;
		}
		if (StringUtils.isEmpty(user.getFullname())) {
			addFieldError("user.fullname", getText("users.fullname.required"));
			return false;
		}
		if (StringUtils.isEmpty(user.getAvatar())) {
			addFieldError("user.avatar", getText("users.avatar.required"));
			return false;
		}
		return true;
	}

	public UserService getUserService() {
		return userService;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
