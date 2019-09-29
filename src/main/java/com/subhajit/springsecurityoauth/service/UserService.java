package com.subhajit.springsecurityoauth.service;

import java.util.List;

import com.subhajit.springsecurityoauth.model.User;

public interface UserService {
	User save(User user);

	List<User> findAll();

	void delete(long id);
}
