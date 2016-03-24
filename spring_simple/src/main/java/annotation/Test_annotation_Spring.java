package annotation;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:annotation/annotation-spring-config.xml")
public class Test_annotation_Spring {
	
	//@Autowired
	//Tiger tiger;
	

	
	//@Autowired
	//Duck duck ;
	
	@Test
	public  void testTiger_info(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:annotation/annotation-spring-config.xml");		
		System.out.println("hello");
	  
		//ApplicationContext.FACTORY_BEAN_PREFIX
	   
		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
	    for(String beanname:beanDefinitionNames){
	    	System.out.println(beanname);   // 打印 所有注册的类的名称
	    }
		System.out.println( "");
		
	}

}
