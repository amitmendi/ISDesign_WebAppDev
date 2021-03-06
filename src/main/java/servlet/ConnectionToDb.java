package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

//This class is used to fetch 3 random recipe info and user info like username and password

public class ConnectionToDb {
//mysql://b5796d9aae2786:9832ca5e@us-cdbr-iron-east-03.cleardb.net/heroku_894d709599a7d70?reconnect=true
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/";

	   //  Database credentials
	   static final String USER = "b5796d9aae2786";
	   static final String PASS = "9832ca5e";
	   
	   public HashMap<String,String> user_info(String email) {
		   
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
	      stmt= conn.prepareStatement("select password,firstname, User_id from heroku_894d709599a7d70.User_Profile where emailid=?");
	      stmt.setString(1,email);  
	      ResultSet res=stmt.executeQuery();
	      while(res.next()){
	          //Retrieve by column name
	          map.put("password",res.getString("password"));
	          map.put("firstname", res.getString("firstname"));
	          map.put("User_id", res.getString("User_id"));
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
		      stmt= conn.prepareStatement("SELECT distinct Recipe_id,Recipe_name,Recipe_desc,Recipe_url,Recipe_steps,Recipe_ing FROM heroku_894d709599a7d70.Recipe order by RAND()");
		      ResultSet res=stmt.executeQuery();
		      while(res.next()){
		          //Retrieve by column name

		    	   Recipe rec = new Recipe();
		    	  rec.setRecipeId(res.getInt(1));  //added so that specific recipe info can be fetched when full recipe is viewed
		    	  rec.setRecipeDesc(res.getString(3));
		    	  rec.setRecipeName(res.getString(2));
		    	  rec.setImgUrl(res.getString(4));
		    	  rec.setRecipeSteps(res.getString(5));		 //added so that specific recipe info can be fetched when full recipe is viewed   	  
		    	  rec.setRecipeIng(res.getString(6));  //added so that specific recipe info can be fetched when full recipe is viewed

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