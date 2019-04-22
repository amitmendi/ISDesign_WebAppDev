package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ReviewServlet
 */

// For deleting a particular recipe from db

@WebServlet("/AdminRecipeServlet")
public class AdminRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    //fetching recipe id from the form
		String recipeId = request.getParameter("recipeid");

	    try{
	    	
	        //checking if recipe id entered by the admin is null
	    	if (recipeId.isEmpty()){
			
				//setting error message
				
				request.setAttribute("null_error2","Kindly enter the recipe id before submitting!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);
				}
	    	
	    	else if (recipeId.matches("\\d+?")){
	    		AdminDb dobj = new AdminDb();
				
	    		dobj.delete_recipe(Integer.parseInt(recipeId));
			
		
				//redirecting back to admin page
				request.setAttribute("success2","The recipe has been deleted from the Recipe table!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);	
	    		
	    	}
	    	else{	
	    		
	    		//setting error message
				
				request.setAttribute("number_error2","Kindly enter the accurate recipe id!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);
			
	    		
				}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}