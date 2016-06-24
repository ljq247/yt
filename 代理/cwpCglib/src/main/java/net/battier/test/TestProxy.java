package net.battier.test;  
  
import net.battier.dao.BookFacade;  
import net.battier.dao.impl.BookFacadeImpl;  
import net.battier.proxy.BookFacadeProxy;  
  
public class TestProxy {  
  
    public static void main(String[] args) {  
        BookFacadeProxy proxy = new BookFacadeProxy();  
        
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());  
        bookProxy.addBook();  
        
//        BookFacade_test bookProxy = (BookFacade_test) proxy.bind(new BookFacadeImpl());
//        System.out.println("11");
        
      //  bookProxy	$Proxy0  (id=22)	
         bookProxy.addBook();  
         System.out.println("end");

    }  
  
}  