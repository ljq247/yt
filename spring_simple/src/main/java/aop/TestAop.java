package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.service.UserService;

public class TestAop {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:/aop/aop-spring-config.xml");				
		UserService service = (UserService)ctx.getBean("userService");
		System.out.println(service.getClass());
		
		System.out.println("=============");
		service.save();
		System.out.println("---------------");
		
		service.saveList();
		
		System.out.println("------------");
		service.around();
		
		System.out.println("------------");
		service.getsavePrivate();
		
	}
}
