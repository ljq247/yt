package com.projectname.service;

import com.projectname.model.User;

public interface IUserService {
	
	public   void insertUser(User user) throws Exception ;
	public   User  findUserById(Integer id);
	
}
