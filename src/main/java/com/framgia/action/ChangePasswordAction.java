package com.framgia.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.framgia.model.User;
import com.opensymphony.xwork2.ActionContext;

public class ChangePasswordAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private User user;
	private String currentPass;
	private String newPass;
	private String reenterPass;
	private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordAction.class);
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String changePasswordAction() {
		return SUCCESS;
	}

	// action change pasword
	@SuppressWarnings("unchecked")
	public String updatePassword() {

		// get from DB
		user = getCurrentUser();
		if (user == null)
			return INPUT;

		// check valid form
		checkValid();

		// set new value fo password
		user.setPassword(passwordEncoder.encode(newPass));
		if (userService.updateUser(user) == null) {
			LOGGER.info("Update password fail !!!");
			return INPUT;
		}

		// update data for session
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");
		session.put("USER", user);
		LOGGER.info("Update password success !!!");
		return SUCCESS;
	}

	// validate
	public void checkValid() {
		if (StringUtils.isEmpty(currentPass)) {
			addFieldError("currentPass", getText("users.password.currentPass.required"));
		}
		if (StringUtils.isEmpty(newPass)) {
			addFieldError("newPass", getText("users.password.newPass.required"));
		}
		if (user == null || !currentPass.equals(user.getPassword())) {
			addFieldError("currentPass", getText("users.password.currentPass.required"));
		}
		if (StringUtils.isEmpty(reenterPass)) {
			addFieldError("reenterPass", getText("users.password.equalNewpass"));
		}
		if (!reenterPass.equals(newPass)) {
			addFieldError("reenterPass", getText("users.password.equalNewpass"));
		}
	}

	// setter & getter
	public String getCurrentPass() {
		return currentPass;
	}

	public void setCurrentPass(String currentPass) {
		this.currentPass = currentPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getReenterPass() {
		return reenterPass;
	}

	public void setReenterPass(String reenterPass) {
		this.reenterPass = reenterPass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
