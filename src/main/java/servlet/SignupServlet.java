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
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//var created to check if email is valid
		boolean valid;
		
		//creating list for storing user info
		ArrayList<String> list = new ArrayList<String>();
		
		// get request parameters for userID and password
		String email = request.getParameter("emailid");
		String pwd = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String confirm_password = request.getParameter("confirm_password");

        //Check for null values, password and email validation
		try{
		if (email.isEmpty() || pwd.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || confirm_password.isEmpty()){
			request.setAttribute("null_error","The above fields are mandatory and cannot be left null!!");
			RequestDispatcher rd=request.getRequestDispatcher("/signup.jsp");            
			rd.include(request, response);
		}
		else if (!pwd.equals(confirm_password)){
			
			request.setAttribute("password_error","Password don't match dawg!!");
			RequestDispatcher rd=request.getRequestDispatcher("/signup.jsp");            
			rd.include(request, response);
		}
		else {
			
			//Check email validation; call method of EmailValidator class
			//private EmailValidator emailValidator;
			EmailValidator emailValidator = new EmailValidator();
			valid = emailValidator.validate(email);
			if (valid != true){
				request.setAttribute("email_error","Emailid entered is invalid!!");
				RequestDispatcher rd=request.getRequestDispatcher("/signup.jsp");            
				rd.include(request, response);
			}
			else{
            //Calling method to store user info into db
			
			StoringToDb dobj = new StoringToDb();
			
			//adding elements to list
			list.add(firstname);
			list.add(lastname);
			list.add(email);
			list.add(pwd);
			
			dobj.store_user_info(list);
			
			//redirecting to respective page
			response.sendRedirect("signupsuccess.jsp");
			}
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}