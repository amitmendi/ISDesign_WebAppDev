package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

//For storing and fetching review information of recipe

public class ReviewDb {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/";

	   //  Database credentials
	   static final String USER = "b5796d9aae2786";
	   static final String PASS = "9832ca5e";
	   
	   //For storing review for a particular recipe
	   
	   public void store_review(ArrayList<Object> list) {
		   		 
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Storing Review to database...");
	      String insertTableSQL = "INSERT INTO heroku_894d709599a7d70.Recipe_Review"
	    			+ "(User_id,Recipe_id,Review_date,Recipe_review) VALUES"
	    			+ "(?,?,?,?)";
	      stmt= conn.prepareStatement(insertTableSQL);
	      for(int i=1; i<=list.size(); i++){
	    	  stmt.setObject(i,list.get(i-1) );
	      }
	      // execute insert SQL statement
	   	  stmt.executeUpdate();

	   	  System.out.println("Review is inserted into the Recipe_Review table!");

	
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
	   
	//for fetching reviews for a particular recipe
	
	   public ArrayList<Review> fetch_review(Integer recipeid) {
		   
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
		      System.out.println("Fetching Review from database...");
		      String insertTableSQL = "select firstname, Review_date, Recipe_review " 
		    		   + "from heroku_894d709599a7d70.User_Profile Inner Join heroku_894d709599a7d70.Recipe_Review "
		    		   + "on heroku_894d709599a7d70.User_Profile.User_id = heroku_894d709599a7d70.Recipe_Review.User_id "
		    		   + "where heroku_894d709599a7d70.Recipe_Review.Recipe_id=?";
		    			
		      stmt= conn.prepareStatement(insertTableSQL);
		      stmt.setInt(1,recipeid);  
		      ResultSet res=stmt.executeQuery();

		      while(res.next()){
		    	  Review rev = new Review();
		    	  rev.setFirstname(res.getString(1));
		    	  rev.setRecipeReview(res.getString(3));
		    	  rev.setReviewdate(res.getDate(2));
		    	  list.add(rev);
		      }
		   	  System.out.println("Review is fetched from Recipe_Review table!");

		  
		
		   }
		   catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			      Review rec = new Review();
		    	  rec.setUserId(0);
		    	  rec.setRecipeReview("Test Review");
		    	  list.add(rec);
			      
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
	   
	   

}//end JDBCExample