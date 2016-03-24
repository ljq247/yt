package aop.aspeck;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;


@Service
public class LogInterceptor {
	
	
	
	//@Before("myMethod()")
	public void before() {
		System.out.println("method before");
	}
	
	//@Around("myMethod()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(" around start");
		pjp.proceed();
		System.out.println("around end");
	}
	
}
