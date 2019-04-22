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

// For deleting a particular review from db

@WebServlet("/AdminReviewServlet")
public class AdminReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	    //fetching review id from the form
		String reviewId = request.getParameter("reviewid");

	    try{
	    	
	        //checking if review id entered by the admin is null
	    	if (reviewId.isEmpty()){
			
				//setting error message
				
				request.setAttribute("null_error3","Kindly enter the review id before submitting!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);
				}
	    	
	    	else if (reviewId.matches("\\d+?")){
	    		AdminDb dobj = new AdminDb();
				
	    		dobj.delete_user(Integer.parseInt(reviewId));
			
		
				//redirecting back to admin page
				request.setAttribute("success3","The review has been deleted from the Review table!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);	
	    		
	    	}
	    	else{	
	    		
	    		//setting error message
				
				request.setAttribute("number_error3","Kindly enter the accurate review id!!");
				RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");            
				rd.include(request, response);
			
	    		
				}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}