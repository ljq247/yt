package com.testjdbcTemplate;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.projectname.model.User;
import com.testjdbcTemplate.service.JdbcUserService;
public class MainTest {
	
	public static void main(String[] args) throws Exception {
	   ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
	   JdbcUserService service=	(JdbcUserService) ctx.getBean("jdbcUserServiceimpl");
	   
	   
	   System.out.println("exe start");
	   
	    service.select();
	    
	    //service.insert();
	    
	    System.out.println("exe  end");
	   
	 
	}

}
