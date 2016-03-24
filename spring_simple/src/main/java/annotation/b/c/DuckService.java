package annotation.b.c;


import org.springframework.stereotype.Service;

@Service
public class DuckService {
	
	public void info(){
		System.out.println("I am "+this.getClass().getName());
	}

}
