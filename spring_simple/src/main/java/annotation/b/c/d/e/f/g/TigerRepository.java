package annotation.b.c.d.e.f.g;

import org.springframework.stereotype.Repository;


@Repository
public class TigerRepository {	
	public void info(){
		System.out.println("I am "+this.getClass().getName());
	}

}
