package proxy.com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
	
	
	private Class t;
	
	public LogInvocationHandler(Class t) {
		this.t = t;
	}

	
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		
			System.out.println("动态代理之前");
			Object object= method.invoke(t.newInstance());
			System.out.println("代理之后");
			return object;
		
		//return "111";
	}

}
