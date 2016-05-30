package com.testjdbcTemplate.service.impl;

import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.testjdbcTemplate.service.JdbcUserService;


@Service
public class JdbcUserServiceimpl  implements JdbcUserService{

	
	@Autowired
	private JdbcTemplate jdbt;

	public void insert() {
		// TODO Auto-generated method stub
		
		String sql_create="INSERT INTO `user` (`id`, `username`, `sex`, `birthday`, `address`) VALUES ('4', '1', '3', '2016-05-09 17:07:51', '3')";
		jdbt.execute(sql_create);
		
		
	
		
		
		System.out.println("创建了4");
		
	}

	public void select() {
		// TODO Auto-generated method stub
		String sql_list="select * from user";
		
		List<Map<String, Object>> list = jdbt.queryForList(sql_list);
		
		String sql_map="select * from user where id=1";	
		Map<String, Object> map = jdbt.queryForMap(sql_map);
		
		
		
		System.out.println();
		
		
	}
}
