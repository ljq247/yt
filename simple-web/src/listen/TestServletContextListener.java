package listen;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class TestServletContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed :执行了");
	}
	/**
	 * 这个方法tomcat 出事化的时候会被执行!
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub		 
		System.out.println("contextInitialized :执行了");
	}
}
