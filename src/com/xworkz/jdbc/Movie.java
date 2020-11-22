package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie {

	public static void main(String[] args) {
		try {
			insertMovie();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



      public static void insertMovie() throws ClassNotFoundException {
    	  
    	  String url="jdbc:mysql://localhost:3306?user=root&password=rootmary";
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  
		try(Connection connection = DriverManager.getConnection(url)){
			try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)){
				 //statement.execute("update jdbc_examples.movie_table set movie_name='Milana' where movie_id=1");
		    	 // statement.execute("insert into jdbc_examples.movie_table values(4,'Manam','Akhil',50000)");
		    	  statement.execute("delete from jdbc_examples.movie_table where movie_id=3");
				
				ResultSet res = statement.executeQuery("select * from jdbc_examples.movie_table ");
				
				/*while(res.next()) {
					int id = res.getInt("movie_id");
					
					String name = res.getString("movie_name");
					String actors = res.getString("movie_actors");
					int budget = res.getInt("movie_budget");
					
					System.out.println( id + " " + name + " " + actors + " " +budget);
				}
			}*/
				
				res.absolute(1);
				int id = res.getInt("movie_id");
				String name = res.getString("movie_name");
				String actors = res.getString("movie_actors");
				int budget = res.getInt("movie_budget");
				System.out.println( id + " " + name + " " + actors + " " +budget);

				
	    	   connection.close();
			}
		


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
      }
      
    			  
    		  
  }
      

      

      

