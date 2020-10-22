package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FestivalsUsingAddbatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
	   try {
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=rootmary");
		Statement st = connection.createStatement();
		st.addBatch("insert into jdbc_examples.festivals_table values(1,'Holi','April',2)");
		st.addBatch("insert into jdbc_examples.festivals_table values(2,'Christmas','Dec',1)");
		
		int a[] =st.executeBatch();
		
		for(int i:a) {
			System.out.println(i);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   finally{
		   try {
			   connection.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
	   }

	}

}
