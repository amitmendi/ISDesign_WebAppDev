package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectionToDb {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Telstra123!";
	   
	   public HashMap<String,String> test(String email) {
		   
	   HashMap<String,String> map = new HashMap<String,String>();
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating database...");
	      stmt= conn.prepareStatement("select password,firstname from FinalProject_Team21.User_Profile where emailid=?");
	      stmt.setString(1,email);  
	      ResultSet res=stmt.executeQuery();
	      while(res.next()){
	          //Retrieve by column name
	          map.put("password",res.getString("password"));
	          map.put("firstname", res.getString("firstname"));
	      }
	
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
	return map;

	
	}//end method
	   
	   public ArrayList<Recipe> fetchRecipes() {
		   
		   ArrayList<Recipe> al = new ArrayList<Recipe>();
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating database...");
		      stmt= conn.prepareStatement("SELECT Recipe_name,Recipe_desc,Recipe_url FROM FinalProject_Team21.Recipe limit 3");
		      ResultSet res=stmt.executeQuery();
		      while(res.next()){
		          //Retrieve by column name
		    	  Recipe rec = new Recipe();
		    	  rec.setRecipeDesc(res.getString(2));
		    	  rec.setRecipeName(res.getString(1));
		    	  rec.setImgUrl(res.getString(3));
		    	  al.add(rec);
		      }
		
		   }
		   catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		      Recipe rec = new Recipe();
	    	  rec.setRecipeDesc("Description");
	    	  rec.setRecipeName("Test Name");
	    	  rec.setImgUrl("./img/Chicken-Tikka-Masala.jpg");
	    	  al.add(rec);
		      
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
		return al;

		
		}//end method
	   

}//end JDBCExample