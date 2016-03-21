package primitiveJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("start:");

		  //1.加载驱动
		  Class.forName("com.mysql.jdbc.Driver");
		  //2.使用DriverManager获取数据库连接
		  //其中返回的Connection就代表了Java程序和数据库的连接
		  Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
		  //3.使用Connection来创建一个Statement对象
		  Statement stmt=conn.createStatement( );
		  //4.执行SQL语句
		  ResultSet rs=stmt.executeQuery("select  * from student");
		  //ResultSet有系列的getXxx(列索引|列名)，用于获取记录指针指向行特定列的值
		  //不断使用next将记录指针移动一行，如果依然指向有效行，则指针指向该行记录
		  while(rs.next())
		  {
		   System.out.println(rs.getInt(1)+"\t"
		    +rs.getString(2));
		  }
   
	}

}
