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

	public String index() {
		users = userService.findAll();
		return SUCCESS;
	}

	public String detail() {
		user = userService.findById(id);
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
	
	public String saveOrUpdateUser() {
		if (saveFile()) {
			userService.saveOrUpdate(user);		
		}
		return SUCCESS;
	}

	public void validate() {
		try {
			if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())
					|| StringUtils.isEmpty(user.getBirthday().toString()) || StringUtils.isEmpty(user.getFullname())
					|| StringUtils.isEmpty(user.getAvatar())) {
				addFieldError("user.username", getText("users.username.required"));
				addFieldError("user.password", getText("users.password.required"));
				addFieldError("user.birthday", getText("users.birthday.required"));
				addFieldError("user.fullname", getText("users.fullname.required"));
				addFieldError("user.avatar", getText("users.avatar.required"));
			}
			if (!user.getPassword().equals(confirmPassword)) {
				addFieldError("confirmPassword", getText("users.confirmPassword.notEqual"));
			}

		} catch (NullPointerException ne) {
		}
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
