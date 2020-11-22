package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJdbc { 
	 
	public static void main(String[] args) {
		
		try {
			insertFirstJdbc();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
			public static void insertFirstJdbc() throws ClassNotFoundException {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Driver driver = new Driver();
				
			//DriverManager.registerDriver(driver);
			
		        try(Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=rootmary")){
			       try(PreparedStatement preparedStatement=connection.prepareStatement("insert into jdbc.veg_table value(?,?,?)")){
			    	   //preparedstatement.execute("insert into jdbc.veg_table values(4,'Onion',80.00)");
			    	   
			    	   //setting d values bfre executing query
			    	   preparedStatement.setInt(1, 5);
			    	   preparedStatement.setString(2,"cauliflower");
			    	   preparedStatement.setDouble(3, 58.00);
			    	   preparedStatement.execute();
			       
		              connection.close();
			       }
		
			       
		         } catch ( SQLException e) {
				    // TODO Auto-generated catch block
				     e.printStackTrace();
			     }
			};
}
		
	


