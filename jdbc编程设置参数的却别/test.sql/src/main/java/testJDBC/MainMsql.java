package testJDBC;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;


public class MainMsql {
	
	public static void main(String[] args) throws Exception {
    System.out.println("");
		
		fun2();


        
        
	}//end main
	
	
	static public void  fun4()throws Exception{  //  �����Ĳ�ѯ
		 //1.��������
      Class.forName("com.mysql.jdbc.Driver");
      //2.ʹ��DriverManager��ȡ���ݿ�����
      //���з��ص�Connection�ʹ�����Java��������ݿ������
      Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
      //3.ʹ��Connection������һ��Statement����
    //  Statement stmt=conn.createStatement( );
      //4.ִ��SQL���
        //  
      Statement stmt=conn.createStatement( );
      //4.ִ��SQL���  	com.mysql.jdbc.StatementImpl@107f45d
      String sql = "select  * from group_t where  name='j\\'ack'";
      ResultSet rs=stmt.executeQuery(sql);
   		   
      
      while(rs.next()){
      	String str1 = rs.getString(1);
      	String str2 = rs.getString(2);
      	System.out.println(str1+"---"+str2);
      }
      
      System.out.println("");
		
	}
	
	static public void  fun3()throws Exception{  // ���Բ�ѯsqlע��
		 //1.��������
       Class.forName("com.mysql.jdbc.Driver");
       //2.ʹ��DriverManager��ȡ���ݿ�����
       //���з��ص�Connection�ʹ�����Java��������ݿ������
       Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
       //3.ʹ��Connection������һ��Statement����
     //  Statement stmt=conn.createStatement( );
       //4.ִ��SQL���
         //  
       A a=new A();
       String sql = "select * from group_t where  name=?";
       PreparedStatement ps = conn.prepareStatement(sql);
       
       ////  name='   jack  or  '1'='1    '
       ps.setString(1, "3'");
       // com.mysql.jdbc.JDBC4PreparedStatement@1bdc9d8:
       ResultSet  rs = ps.executeQuery();
       
       while(rs.next()){
       	String str1 = rs.getString(1);
       	String str2 = rs.getString(2);
       	System.out.println(str1+"---"+str2);
       }
       
       System.out.println("");
		
	}
	
	static public void  fun2()throws Exception{
		
       //1.��������
       Class.forName("com.mysql.jdbc.Driver");
       //2.ʹ��DriverManager��ȡ���ݿ�����
       //���з��ص�Connection�ʹ�����Java��������ݿ������
       Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
       //3.ʹ��Connection������һ��Statement����
     //  Statement stmt=conn.createStatement( );
       //4.ִ��SQL���
         //  
       String sql = "select * from group_t where  id=?  and  test_decimal=?  and  test_datetime=? and test_timestamp=?" ;
       PreparedStatement ps = conn.prepareStatement(sql);
       ps.setString(1, "1");
       ps.setInt(2, 2);
       Date dd =new Date(2011-1900, 2, 22);
       System.out.println(dd.toString());
       ps.setDate(3, dd );
       Timestamp ts = new Timestamp(System.currentTimeMillis());   
       System.out.println("timestamp:"+ts);
       
       ps.setTimestamp(4, ts);
       
       
       ResultSet  rs = ps.executeQuery();
       
       System.out.println("");
       
       
       
  
       
	}
	
 static  	public  void  fun1()throws Exception{
		System.out.println( "hell o");
		
		
       //1.��������
       Class.forName("com.mysql.jdbc.Driver");
       //2.ʹ��DriverManager��ȡ���ݿ�����
       //���з��ص�Connection�ʹ�����Java��������ݿ������
       Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
       //3.ʹ��Connection������һ��Statement����
       Statement stmt=conn.createStatement( );
       //4.ִ��SQL���
       ResultSet rs=stmt.executeQuery("select  * from group_t");
       //ResultSet��ϵ�е�getXxx(������|����)�����ڻ�ȡ��¼ָ��ָ�����ض��е�ֵ
       //����ʹ��next����¼ָ���ƶ�һ�У������Ȼָ����Ч�У���ָ��ָ����м�¼
       
       ResultSetMetaData rsmd  = rs.getMetaData();
       Integer columnCount= rsmd.getColumnCount();
       
       for(int i=1;i<=rsmd.getColumnCount();i++){
       	System.out.println("columnname:"+rsmd.getColumnName(i)	+
       			"  --������: "+rsmd.getColumnType(i)  +
       			"--��������:"+rsmd.getColumnTypeName(i)+
       			"--����:"+rsmd.getColumnDisplaySize(i)+
       			"--cloumnLab:"+rsmd.getColumnLabel(i)
       			
       			
       			);
       }  
       System.out.println("���������:"+ rsmd.getColumnCount()); 
       System.out.println("ͨ����Ż�ȡ����---------|");
       while(rs.next())
       {
       	System.out.print("��Ż�ȡ������--�������Ϊ:");
       	for(int i=1;i<=columnCount;i++){
       		System.out.print(rs.getString(i)+"|--|");
       	}
       	System.out.println("");//�س�
       	
       	
       	System.out.print("������ȡ������-");
           for(int i=1;i<=columnCount;i++){
           	System.out.print(  "|--|" + rsmd.getColumnName(i)   +":"+ rs.getString(  rsmd.getColumnName(i) )  );
           
           } 
           System.out.println("");//�س�
       	
         //  System.out.println(rs.getd);
       }
	
         System.out.println("ʱ��:"+rs.getDate("test_datetime"));  ;
 }//end fun1
	

}
