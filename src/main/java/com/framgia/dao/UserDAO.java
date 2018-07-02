package com.framgia.dao;

import com.framgia.model.User;

public interface UserDAO extends BaseDAO<User, Integer> {

	User findByUsenameAndPassword(String username, String password);

}
