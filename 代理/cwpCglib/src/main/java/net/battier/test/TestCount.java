package net.battier.test;  
  
import net.battier.dao.impl.CountImpl;  
import net.battier.dao.impl.CountProxy;  
  
/** 
 *测试Count类 
 *  这种代理的缺陷是,必须为每个代理写代理的方法
 *  不科学!
 * @author Administrator 
 *  
 */  

public class TestCount {  
	
    public static void main(String[] args) {  
        CountImpl countImpl = new CountImpl();  
        CountProxy countProxy = new CountProxy(countImpl);  
        countProxy.updateCount();  
    }  
}  