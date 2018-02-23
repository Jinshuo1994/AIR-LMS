package air.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private final String DBDRIVER = "com.mysql.jdbc.Driver";
	private final String DBURL = "jdbc:mysql://localhost:3306/airlmsdb?useUnicode=true&characterEncoding=utf-8";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "root";
	private Connection conn;
	
	//DRIVER is the JDBC driver for your connection to the database.
	   //DBURL is the connection URL.
	   //DBUSER is the username of your MySQL.
	   //DBPASSWORD is the password of your MySQL.
	   public DBConnect(){
		   try{
			   Class.forName(DBDRIVER);
			   this.conn=DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		   }catch(Exception e){
			   System.out.println(e.getMessage());
		   }
	   }
	   
	   public Connection getConnection(){
		   return this.conn;
	   }
	   
	   public void close(){
		   try{
			   this.conn.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
}
