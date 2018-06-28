package com.framgia.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.framgia.model.User;
import com.framgia.search.SearchUser;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private List<User> users;
	private User user;
	private String searchKeyword;
	private final String path = "/home/namnguyen/Desktop/upload/";
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String confirmPassword;

	public String listUser() {
		SearchUser searchUser = new SearchUser();
		searchUser.setKeyword(getSearchKeyword());
		users = userService.getUser(searchUser);
		return SUCCESS;
	}

	public String newUser() {
		return SUCCESS;
	}

	public String saveOrUpdateUser() {
		if (user.getId() == null) {
			userService.saveUser(user);
		}
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

	public void validate() {
		
		try {
			SearchUser searchUser=new SearchUser();
			searchUser.setKeyword(user.getUsername());
			if(!saveFile()){
				addFieldError("user.avatar", getText("users.avatar.required"));
			}
			if (user.getUsername().equals("")||user.getPassword().equals("")
					||user.getBirthday().toString().equals("")
					||user.getFullname().equals("")
					){
				addFieldError("user.username", getText("users.username.required"));
				addFieldError("user.password", getText("users.password.required"));
				addFieldError("user.birthday", getText("users.birthday.required"));
				addFieldError("user.fullname", getText("users.fullname.required"));
			}
			if(!user.getPassword().equals(confirmPassword)){
				addFieldError("confirmPassword", getText("users.confirmPassword.notEqual"));
			}
			
			if(!userService.getUser(searchUser).isEmpty()){
				addFieldError("user.usernameExist", getText("users.username.exist"));
			}
			
		} catch (NullPointerException ne) {
		}
	}
	
	

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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


}
