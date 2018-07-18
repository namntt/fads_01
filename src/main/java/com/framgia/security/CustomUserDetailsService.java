package com.framgia.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;

public class CustomUserDetailsService implements UserDetailsService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userDAO.findBy("username", username);
			CustomUserDetails userDetail = new CustomUserDetails();
			userDetail.setId(user.getId());
			userDetail.setUsername(user.getUsername());
			userDetail.setPassword(user.getPassword());
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			userDetail.setAuthorities(authorities);
			return userDetail;
		} catch (Exception e) {
			return null;
		}
	}

}
