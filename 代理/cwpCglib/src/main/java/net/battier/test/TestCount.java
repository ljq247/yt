package net.battier.test;  
  
import net.battier.dao.impl.CountImpl;  
import net.battier.dao.impl.CountProxy;  
  
/** 
 *����Count�� 
 *  ���ִ����ȱ����,����Ϊÿ������д����ķ���
 *  ����ѧ!
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