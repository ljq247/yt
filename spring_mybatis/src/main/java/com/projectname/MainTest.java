package com.projectname;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projectname.model.User;
import com.projectname.service.IUserService;
public class MainTest {
	
	public static void main(String[] args) throws Exception {
	   ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
	   IUserService userService=	(IUserService) ctx.getBean("userServiceImpl");
	   User user = userService.findUserById(1);
	   System.out.println(user);
	   
	   
	   User u1=new User();
	   u1.setUsername("青蛙");
	   u1.setSex("1");
	   u1.setSex(null);
	   userService.insertUser(u1);
	   System.out.println(userService);
	 
	}

}
