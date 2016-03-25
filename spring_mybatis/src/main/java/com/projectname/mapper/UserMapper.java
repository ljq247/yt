package com.projectname.mapper;

import java.util.List;

import com.projectname.model.User;


/**
 * 
 * @author:小南风 2016年3月24日
 *
 */
public interface UserMapper {	

	//根据id查询用户信息
	public User findUserById(int id);
	public void insertUser(User user);
//	
//	//根据id查询用户信息，使用resultMap输出
//	public User findUserByIdResultMap(int id) throws Exception;
//	
//	
//	//根据用户名列查询用户列表
//	public List<User> findUserByName(String name)throws Exception;
//	
//	//插入用户

//	
//	//删除用户
//	public void deleteUser(int id)throws Exception;

}

