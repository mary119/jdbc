package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FestivalsTransaction {

	public static void main(String[] args) {

		Connection con = null;
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:/3306/jdbc_examples","root", "rootmary" ); 
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			st.addBatch("insert into jdbc_examples.festivals_table values (1,'Ganesh','Sept',1)");
			st.addBatch("insert into jdbc_examples.festivals_table values (1,'Onam','Aug',1)");
			
			int[] a = st.executeBatch();
			con.commit();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		    
			try {
			  con.rollback();
		    } catch (SQLException e) {
		  	// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	     }
	     
		finally {
		  try {
			con.close();
		  } catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	
	}


