package com.subhajit.springsecurityoauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.springsecurityoauth.model.User;
import com.subhajit.springsecurityoauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return "success";
	}

}
