package servlet;
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

//For storing and fetching review information of recipe

public class SearchRecipeDb {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/";

	   //  Database credentials
	   static final String USER = "b5796d9aae2786";
	   static final String PASS = "9832ca5e";
	   
	    //For searching recipes matching the keyword searched by the user
	   //Eg: if user searches chicken, so it should show all the recipes containing chicken
	   
	   public ArrayList<Recipe> search_recipe(String recipeName) {
		 
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   
	   ArrayList<Recipe> recList = new ArrayList<Recipe>();
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("fetching recipe from database...");
	      String insertTableSQL = "Select Recipe_id, Recipe_name,Recipe_desc,Recipe_url,Recipe_steps,Recipe_ing from heroku_894d709599a7d70.Recipe where Lower(Recipe_name) like ?";
	      stmt= conn.prepareStatement(insertTableSQL);
	      stmt.setString(1,"%"+recipeName+"%");  
	      ResultSet res=stmt.executeQuery();
	      while(res.next()){
	          //Retrieve by column name and setting to class object
	    	  Recipe rec = new Recipe();
	          rec.setRecipeId(res.getInt("Recipe_id"));
	          rec.setRecipeName(res.getString("Recipe_name"));
	          rec.setRecipeDesc(res.getString("Recipe_desc"));
	          rec.setRecipeSteps(res.getString("Recipe_steps"));
	          rec.setRecipeIng(res.getString("Recipe_ing"));
	          rec.setImgUrl(res.getString("Recipe_url"));
	          
	          //Adding to <recipe> list
	          recList.add(rec);

	      }
	     

	   	  System.out.println("Recipe is fetched from Recipe table!");

	
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
	return recList;


	
	}//end method
	   
	
}//end JDBCExample