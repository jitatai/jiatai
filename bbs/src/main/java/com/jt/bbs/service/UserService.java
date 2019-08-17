package com.jt.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.bbs.dao.UserMapper;
import com.jt.bbs.entity.User;
import com.jt.bbs.entity.UserExample;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	public User login(String name,String password){
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			throw new RuntimeException("用户名或密码错误");
		}
		return list.get(0);
	}
}
