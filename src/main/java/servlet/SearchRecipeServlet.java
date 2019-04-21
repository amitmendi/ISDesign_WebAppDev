package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RecipeServlet
 */

//This servlet class is used to fetch recipe info based on user input in the search bar

@WebServlet("/SearchRecipeServlet")
public class SearchRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    
		    //creating Recipe object list to capture searched recipe information
		    ArrayList<Recipe> recList = new ArrayList<Recipe>();
	
			//fetching the recipe name searched from landingpage search form
			String recipeName = request.getParameter("search");

			// checking in db if this recipe is available
			SearchRecipeDb search = new SearchRecipeDb();
			recList = search.search_recipe(recipeName.toLowerCase());
			
			
			//Checking if recipe list returned from db is null 
			
			if (recList.isEmpty()){
				request.setAttribute("search_error","Sorry. This recipe is not avilable at the moment!!");
				RequestDispatcher rd=request.getRequestDispatcher("/landingpage.jsp");            
				rd.include(request, response);
			}
			else {
				
			
				//setting recipe object list to request
				request.setAttribute("recipeList", recList);
				request.setAttribute("recipe_searched", recipeName);
				//redirecting to respective page

				RequestDispatcher rd =  request.getRequestDispatcher("/searchrecipe.jsp"); 
				rd.include(request, response); 
			}
			
			
			}
		
		
		
		
	

}