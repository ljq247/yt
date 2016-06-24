package net.battier.test;  
  
import net.battier.dao.impl.BookFacadeImpl1;  
import net.battier.proxy.BookFacadeCglib;  
  
public class TestCglib {  
      
    public static void main(String[] args) {  
        BookFacadeCglib cglib=new BookFacadeCglib(); 
        //	bookCglib	=	BookFacadeImpl1$$EnhancerByCGLIB$$a6ea2df0  (id=26)	
        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());  
        bookCglib.addBook();  
    }  
}  