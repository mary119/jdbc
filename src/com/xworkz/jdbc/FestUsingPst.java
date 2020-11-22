package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FestUsingPst {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=rootmary");
		
		
		    //con.setAutoCommit(false);
		     PreparedStatement pst = con.prepareStatement("insert into jdbc_examples.festivals_table values (?,?,?,?)");
		     pst.setInt(1, 3);
		     pst.setString(2, "Easter");
		     pst.setString(3, "April");
		     pst.setInt(4, 3);
		     pst.addBatch();
		
		     pst.setInt(1, 4);
		     pst.setString(2, "Dasara");
		     pst.setString(3, "Oct");
		     pst.setInt(4, 15);
		     pst.addBatch();
		     pst.executeBatch();
	         con.close();


		     //execute the queries
		     //int a[]=pst.executeBatch();
	       	//for(int i:a) {
		    //	System.out.println(i);
		     //}
	     	//pst.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 //con.commit();


	};

}

