package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

//For fetching user profile information from db

public class UserProfileDb {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/";

	   //  Database credentials
	   static final String USER = "b5796d9aae2786";
	   static final String PASS = "9832ca5e";
	   
	   //For fetching user info from user profile table based on user Id
	   
	   public User fetch_user(Integer userId) {
		  
	   //creating User object
		   
	   User userObj = new User();
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Fetching user from database...");
	      String insertTableSQL = "Select firstname, lastname, emailid, password from heroku_894d709599a7d70.User_profile where User_id =?";
	      stmt= conn.prepareStatement(insertTableSQL);
			
	      stmt= conn.prepareStatement(insertTableSQL);
	      stmt.setInt(1,userId);  
	      ResultSet res=stmt.executeQuery();

	      while(res.next()){
	    	 userObj.setEmailid(res.getString(3));
	    	 userObj.setFirstname(res.getString(1));
	    	 userObj.setLastname(res.getString(2));
	    	 userObj.setPassword(res.getString(4));
	      }

	   	  System.out.println("User info is fetched from User_profile table!");

	
	   }
	   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end finally
	   System.out.println("Goodbye!");
	return userObj;


	
	}//end method
	   
	//for fetching reviews for a particular recipe
	
	   public void update_user(ArrayList<String> list, Integer userId) {
		   
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Updating user info in database...");
		      String insertTableSQL = "Update heroku_894d709599a7d70.User_Profile Set firstname=?,lastname=?,password=? Where User_id=?";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      
		      stmt.setString(1, list.get(0));
		      stmt.setString(2, list.get(1));
		      stmt.setString(3, list.get(2));
		      stmt.setInt(4, userId);

		      //execute query
		      stmt.executeUpdate();

		     
		   	  System.out.println("User profile is updated succesfully!");

		  
		
		   }
		   catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			      
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end finally
		   System.out.println("Goodbye!");
		   

		}//end method
	   
	   

}//end JDBCExample