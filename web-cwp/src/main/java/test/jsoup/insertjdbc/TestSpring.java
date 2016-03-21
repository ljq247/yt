package test.jsoup.insertjdbc;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.jsoup.insertjdbc.model.City;

public class TestSpring {
	
	 private static ApplicationContext  ctx;
	 @BeforeClass
	 public static void beforeClass(){
	  ctx = new ClassPathXmlApplicationContext("spring/springContext.xml");
	 System.out.println("i m beforClass");
	 }
	
	@Test 
	public  void insert(){
		System.out.println("ÄãºÃ");
		 CityDao cd=    (CityDao) ctx.getBean("cityDao");
		 
		// List list= cd.findALL();
		 City city= cd.findCityByid(1);
		 cd.insert(city);
		 System.out.println(city.toString());
	}


}
