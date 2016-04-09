package primitiveJDBC;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Jdbc_Main {
	
	
	@Test
	public  void  fun1() throws SQLException, ClassNotFoundException {
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
	@Test
	public void testDataSource() throws PropertyVetoException, SQLException{
		
		ComboPooledDataSource  dataSource = new  com.mchange.v2.c3p0.ComboPooledDataSource();

		dataSource.setDriverClass("com.mysql.jdbc.Driver" );
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUser("root");
		dataSource.setPassword("123456");	
        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(5);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
        
		DataSource   ds= dataSource;
	  //  Connection c1=ds.getConnection();
        
	    for(int i=1;i<=4;i++){
	    ds.getConnection();
	    }
	    
		  //4.执行SQL语句
	    Connection	conn =null;
		for(int i=1;i<5;i++){
		conn = ds.getConnection();
		System.out.println(conn);
		conn.setAutoCommit(false);  ///禁止自动提交
		String	sql="insert into student(id,name) values(2,'美国')";
		Statement stmt =conn.createStatement( );
		stmt.executeUpdate(sql); 
		if(i==4)break ;
		conn.close();
		}
		conn.commit();
		//conn.rollback();

		
	}

}
///	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
//<property name="driverClass" value="${connection.driverclass}" />
//<property name="jdbcUrl" value="${connection.url}" />
//<property name="user" value="${connection.username}" />
//<property name="password" value="${connection.password}" />
//<property name="initialPoolSize" value="${connection.initialPoolSize}" />
//<property name="minPoolSize" value="${connection.minPoolSize}" />
//<property name="maxPoolSize" value="${connection.maxPoolSize}" />
//<property name="maxIdleTime" value="${connection.maxIdleTime}" />
//<property name="preferredTestQuery" value="${connection.preferredTestQuery}" />
//<property name="idleConnectionTestPeriod" value="${connection.idleConnectionTestPeriod}" />
//<property name="testConnectionOnCheckout" value="${connection.testConnectionOnCheckout}" />
//connection.driverclass=com.mysql.jdbc.Driver
//##connection.url=jdbc\:mysql\://10.142.12.208\:3306/InvFinAdmin?useUnicode\=true&characterEncoding\=UTF-8
//connection.url=jdbc\:mysql\://127.0.0.1\:3306/Mybatis?useUnicode\=true&characterEncoding\=UTF-8
//connection.username=root
//##connection.password=2a4c094bbb588e8169
//connection.password=123456
//connection.initialPoolSize=10
//connection.minPoolSize=20
//connection.maxPoolSize=50
//connection.maxIdleTime=1800
//connection.preferredTestQuery=SELECT 1 
//connection.idleConnectionTestPeriod=18000
//connection.testConnectionOnCheckout=true
