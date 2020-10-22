package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataExample {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_examples" ,"root","rootmary");
			DatabaseMetaData metaData = con.getMetaData();
			System.out.println(metaData.getDatabaseMajorVersion());
			System.out.println(metaData.getDatabaseProductName());
			
			//ResultSet resultSet = metaData.getTables(null, null, null, null);
			ResultSet resultSet = metaData.getColumns(null, null, "festivals_table", null);

			while(resultSet.next())
			{
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getInt(5));
			}
			
			/*String sql = ("select * from movie_table");
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(sql);
			ResultSetMetaData data = resultSet.getMetaData();
			System.out.println(data.getSchemaName(2));*/
			
			String sql = ("select * from festivals_table");
			Statement statement = con.createStatement();
			ResultSet resultSet2 = statement.executeQuery(sql);
			ResultSetMetaData metaData2 = resultSet2.getMetaData();
		    System.out.println(metaData2.getColumnCount());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	}

}
