package com.jt.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jt.bbs.common.Result;
import com.jt.bbs.entity.User;
import com.jt.bbs.service.UserService;

@RestController
@SessionAttributes("loginedUser")
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public Result<User> login(String name,String password,Model model){
		User user = null;
		try {
			user = userService.login(name, password);
		} catch (Exception e) {
			return new Result<User>(0,e.getMessage());
		}
		model.addAttribute("loginedUser", user);
		return new Result<User>(1, "OK");
	}

}
