package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

//class to fetch info and delete info from db for the admin

public class AdminDb {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/";

	   //  Database credentials
	   static final String USER = "b5796d9aae2786";
	   static final String PASS = "9832ca5e";
	   
	 //for fetching all users from the db
		
	   public ArrayList<User> fetch_users() {
		   
		   ArrayList<User> list = new ArrayList<User>();
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Fetching all users from database...");
		      String insertTableSQL = "select User_id, firstname,lastname,emailid from heroku_894d709599a7d70.User_Profile";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      ResultSet res=stmt.executeQuery();

		      while(res.next()){
		    	  User user = new User();
		    	  user.setUserId(res.getInt("User_id"));
		    	  user.setFirstname(res.getString("firstname"));
		    	  user.setLastname(res.getString("lastname"));
		    	  user.setEmailid(res.getString("emailid"));
		    	  list.add(user);
		      }
		   	  System.out.println("All users fetched from User_Profile table!");

		  
		
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
		   
		   return list;

		}//end method
	   
//For fetching all the recipes from the db
	   
public ArrayList<Recipe> fetch_recipes() {
		   
		   ArrayList<Recipe> list = new ArrayList<Recipe>();
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Fetching all users from database...");
		      String insertTableSQL = "SELECT Recipe_id, Recipe_name,Recipe_desc,Recipe_url,Recipe_steps,Recipe_ing FROM heroku_894d709599a7d70.Recipe";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      ResultSet res=stmt.executeQuery();

		      while(res.next()){
		    	  Recipe rec = new Recipe();
		    	  rec.setRecipeId(res.getInt("Recipe_id"));
		    	  rec.setRecipeDesc(res.getString("Recipe_desc"));
		    	  rec.setRecipeName(res.getString("Recipe_name"));
		    	  rec.setRecipeSteps(res.getString("Recipe_steps"));
		    	  rec.setRecipeIng(res.getString("Recipe_ing"));
		    	  rec.setImgUrl(res.getString("Recipe_url"));

		    	  list.add(rec);
		      }
		   	  System.out.println("All recipes fetched from Recipe table!");

		  
		
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
		   
		   return list;

		}//end method	

//For fetching all the reviews from the db

public ArrayList<Review> fetch_reviews() {
		   
		   ArrayList<Review> list = new ArrayList<Review>();
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Fetching all reviews from database...");
		      String insertTableSQL = "SELECT Review_id,User_id,Recipe_id, Review_date,Recipe_review FROM heroku_894d709599a7d70.Recipe_Review";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      ResultSet res=stmt.executeQuery();

		      while(res.next()){
		    	  Review rev = new Review();
		    	  rev.setRecipeId(res.getInt("Recipe_id"));
		    	  rev.setUserId(res.getInt("User_id"));
		    	  rev.setReviewId(res.getInt("Review_id"));
		    	  rev.setReviewdate(res.getDate("Review_date"));
		    	  rev.setRecipeReview(res.getString("Recipe_review"));

		    	  list.add(rev);
		      }
		   	  System.out.println("All reviews fetched from Review table!");

		  
		
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
		   
		   return list;

		}//end method

//For deleting a particular user from the db

public void delete_user(Integer userid) {
		   
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Deleting the user from database...");
		      String insertTableSQL = "Delete FROM heroku_894d709599a7d70.User_Profile where User_id=?";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      stmt.setInt(1,userid);  
		      stmt.executeUpdate();

		   
		   	  System.out.println("The user is deleted from the User_profile table!");

		  
		
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

//For deleting a particular recipe from the db

public void delete_recipe(Integer recipeid) {
		   
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Deleting the recipe from database...");
		      String insertTableSQL = "Delete FROM heroku_894d709599a7d70.Recipe where Recipe_id=?";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      stmt.setInt(1,recipeid);  
		      stmt.executeUpdate();

		     
		   	  System.out.println("The recipe is deleted from Recipe table!");

		  
		
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


//For deleting a particular review from the db

public void delete_review(Integer reviewid) {
		   
			 
		   
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Deleting the review from database...");
		      String insertTableSQL = "Delete FROM heroku_894d709599a7d70.Recipe_Review where Review_id=?";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      stmt.setInt(1,reviewid);  
		      stmt.executeUpdate();

		     
		   	  System.out.println("The review is deleted from Review table!");

		  
		
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