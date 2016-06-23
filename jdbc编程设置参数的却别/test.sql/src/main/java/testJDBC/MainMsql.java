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
	
	
	static public void  fun4()throws Exception{  //  正常的查询
		 //1.加载驱动
      Class.forName("com.mysql.jdbc.Driver");
      //2.使用DriverManager获取数据库连接
      //其中返回的Connection就代表了Java程序和数据库的连接
      Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
      //3.使用Connection来创建一个Statement对象
    //  Statement stmt=conn.createStatement( );
      //4.执行SQL语句
        //  
      Statement stmt=conn.createStatement( );
      //4.执行SQL语句  	com.mysql.jdbc.StatementImpl@107f45d
      String sql = "select  * from group_t where  name='j\\'ack'";
      ResultSet rs=stmt.executeQuery(sql);
   		   
      
      while(rs.next()){
      	String str1 = rs.getString(1);
      	String str2 = rs.getString(2);
      	System.out.println(str1+"---"+str2);
      }
      
      System.out.println("");
		
	}
	
	static public void  fun3()throws Exception{  // 测试查询sql注入
		 //1.加载驱动
       Class.forName("com.mysql.jdbc.Driver");
       //2.使用DriverManager获取数据库连接
       //其中返回的Connection就代表了Java程序和数据库的连接
       Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
       //3.使用Connection来创建一个Statement对象
     //  Statement stmt=conn.createStatement( );
       //4.执行SQL语句
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
		
       //1.加载驱动
       Class.forName("com.mysql.jdbc.Driver");
       //2.使用DriverManager获取数据库连接
       //其中返回的Connection就代表了Java程序和数据库的连接
       Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
       //3.使用Connection来创建一个Statement对象
     //  Statement stmt=conn.createStatement( );
       //4.执行SQL语句
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
		
		
       //1.加载驱动
       Class.forName("com.mysql.jdbc.Driver");
       //2.使用DriverManager获取数据库连接
       //其中返回的Connection就代表了Java程序和数据库的连接
       Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","123456");
       //3.使用Connection来创建一个Statement对象
       Statement stmt=conn.createStatement( );
       //4.执行SQL语句
       ResultSet rs=stmt.executeQuery("select  * from group_t");
       //ResultSet有系列的getXxx(列索引|列名)，用于获取记录指针指向行特定列的值
       //不断使用next将记录指针移动一行，如果依然指向有效行，则指针指向该行记录
       
       ResultSetMetaData rsmd  = rs.getMetaData();
       Integer columnCount= rsmd.getColumnCount();
       
       for(int i=1;i<=rsmd.getColumnCount();i++){
       	System.out.println("columnname:"+rsmd.getColumnName(i)	+
       			"  --类型是: "+rsmd.getColumnType(i)  +
       			"--类型名称:"+rsmd.getColumnTypeName(i)+
       			"--长度:"+rsmd.getColumnDisplaySize(i)+
       			"--cloumnLab:"+rsmd.getColumnLabel(i)
       			
       			
       			);
       }  
       System.out.println("表的所有列:"+ rsmd.getColumnCount()); 
       System.out.println("通过序号获取数据---------|");
       while(rs.next())
       {
       	System.out.print("序号获取的数据--这窜数据为:");
       	for(int i=1;i<=columnCount;i++){
       		System.out.print(rs.getString(i)+"|--|");
       	}
       	System.out.println("");//回车
       	
       	
       	System.out.print("类名获取的数据-");
           for(int i=1;i<=columnCount;i++){
           	System.out.print(  "|--|" + rsmd.getColumnName(i)   +":"+ rs.getString(  rsmd.getColumnName(i) )  );
           
           } 
           System.out.println("");//回车
       	
         //  System.out.println(rs.getd);
       }
	
         System.out.println("时间:"+rs.getDate("test_datetime"));  ;
 }//end fun1
	

}
