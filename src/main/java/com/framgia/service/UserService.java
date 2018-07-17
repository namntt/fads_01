package com.framgia.service;

import java.util.List;

import com.framgia.model.User;

public interface UserService {

	List<User> findAll();

	User findById(Integer id);

	User findByUsername(String username);

	User findByUsenameAndPassword(String username, String password);

	User addUser(User user);

	User updateUser(User user);

}
