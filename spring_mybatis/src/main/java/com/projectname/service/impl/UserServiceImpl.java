package com.projectname.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectname.mapper.UserMapper;
import com.projectname.model.User;
import com.projectname.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	public UserMapper userMapper;
	
	public   User  findUserById(Integer id) {
	    return 	userMapper.findUserById(id ) ;
	}
	
	public   void insertUser(User user) {
	
			userMapper.insertUser(user);			
			//userMapper.insertUser(user);
			
	}

}
