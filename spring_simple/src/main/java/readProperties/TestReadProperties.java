package readProperties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import readProperties.com.util.PropertyUtil;


public class TestReadProperties {

	
	@Test
	public  void testReadProperties(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:readProperties/read-properties-spring-config.xml");		
		 System.out.println("--------------");
		 for(String key: PropertyUtil.ctxPropertiesMap.keySet()){
			 System.out.println("key=="+key+"---value:"+PropertyUtil.ctxPropertiesMap.get(key));
		 }  		
	}
}
