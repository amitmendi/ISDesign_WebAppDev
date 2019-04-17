package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

public class StoringToDb {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Telstra123!";
	   
	   public void store_user_info(ArrayList<String> list) {
		   
	   //HashMap<String,String> map = new HashMap<String,String>();
		 
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Storing to database...");
	      String insertTableSQL = "INSERT INTO FinalProject_Team21.User_Profile"
	    			+ "(firstname,lastname,emailid,password) VALUES"
	    			+ "(?,?,?,?)";
	      stmt= conn.prepareStatement(insertTableSQL);
	      for(int i=1; i<=list.size(); i++){
	    	  stmt.setString(i,list.get(i-1) );
	      }
	      // execute insert SQL statement
	   	  stmt.executeUpdate();

	   	  System.out.println("Record is inserted into the user_profile table!");

	  
	
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