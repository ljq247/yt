package proxy.com.test;

import java.lang.reflect.Proxy;

public class ClassProxy {
	
	
	@SuppressWarnings({ "rawtypes" })
	Object get(Class t){
		Class[] proxyInterface = t.getInterfaces();
		LogInvocationHandler	lon = new LogInvocationHandler(t);
		return  Proxy.newProxyInstance(ClassProxy.class.getClassLoader(), proxyInterface, lon);
	}
	
	
	
	
	public static void main(String[] args) {
		Test test = (Test) new ClassProxy().get(Testimple.class);
		System.out.println(test.sys());
	}
	

}
