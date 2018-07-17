package com.framgia.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomSessionAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	public enum Role {
		ROLE_ADMIN, ROLE_USER
	}

	public String execute() {

		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			List<String> roles = new ArrayList<String>();

			Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) userDetails
					.getAuthorities();

			for (Iterator<SimpleGrantedAuthority> i = authorities.iterator(); i.hasNext();) {
				SimpleGrantedAuthority authority = (SimpleGrantedAuthority) i.next();
				roles.add(authority.getAuthority());
			}
			if (isAdmin(roles))
				return "SUCCESS_ADMIN";
			else if (isUser(roles))
				return "SUCCESS_USER";
			else
				return "Acess_Denied";
		} catch (Exception e) {
			return "Acess_Denied";
		}
	}

	private boolean isAdmin(List<String> roles) {
		return roles.contains(Role.ROLE_ADMIN.toString());
	}

	private boolean isUser(List<String> roles) {
		return roles.contains(Role.ROLE_USER.toString());
	}
}
