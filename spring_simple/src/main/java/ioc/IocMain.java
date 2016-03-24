package ioc;

import ioc.a.b.c.e.f.g.Banana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("ioc/ioc-spring-config.xml");
		
		 Banana  banana=(Banana) ctx.getBean("banana_id");
		 banana.info();
		
		System.out.println("hello over" );
		
	}

}
