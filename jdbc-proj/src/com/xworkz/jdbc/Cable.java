package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Cable {

	public static void main(String[] args)  {
		
		try {
		    insertCable();
	     }   catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}



           public static void insertCable() throws ClassNotFoundException {
        	
      	      Class.forName("com.mysql.cj.jdbc.Driver");
      	  
      	       try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=rootmary")){
      	           try( Statement st = con.createStatement()){
      	    
      	             st.execute("insert into jdbc_examples.cables_table value(3,'dth','yearly',400)");
      	            }
      	               con.close();
   
      	  
		       } catch (SQLException e) {
			 
		    	  e.printStackTrace();
		        }
        }
	
        

 }
	
		
		






