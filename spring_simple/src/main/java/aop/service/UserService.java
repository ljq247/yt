package aop.service;

import org.springframework.stereotype.Service;


@Service 
public class UserService {

	
	public void save(){
		System.out.println("Userservice.save  run");
	}
	
	public void saveList(){
		System.out.println("Userservice.saveList  run");
	}
	
	
	public void  around(){
		System.out.println("Userservice.around()  run");
	}
	private void savePrivate(){
		  System.out.println("Userservice.savePrivate()  run");
	}
	public void getsavePrivate(){
		System.out.println("Userservice.getsavePrivate()  run");
		savePrivate();
	}
}
