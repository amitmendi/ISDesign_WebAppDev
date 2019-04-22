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

// For deleting a particular user from db

@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    //fetching user id from the form
		String userId = request.getParameter("userid");

	    try{
	    	
	        //checking if user id entered by the admin is null
	    	if (userId.isEmpty()){
			
				//setting error message
				
				request.setAttribute("null_error","Kindly enter the user id before submitting!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);
				}
	    	
	    	else if (userId.matches("\\d+?")){
	    		AdminDb dobj = new AdminDb();
				
	    		dobj.delete_user(Integer.parseInt(userId));
			
		
				//redirecting back to admin page
				request.setAttribute("success","The user has been deleted from the User Profile table!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);	
	    		
	    	}
	    	else{	
	    		
	    		//setting error message
				
				request.setAttribute("number_error","Kindly enter the accurate user id!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);
			
	    		
				}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}