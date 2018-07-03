package com.framgia.service;

import java.util.List;

import com.framgia.model.User;

public interface UserService {

	List<User> findAll();

	User findById(Integer id);

	User findByUsenameAndPassword(String username, String password);
	
	User saveOrUpdate(User user);

}
