package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SignupServlet
 */
//Servlet to give call to user User Profile db and fetching details to display and update
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		User userObj = new User();
		//Getting user id of the user logged in from cookie
		//Original definition of cookie in LoginServlet when given call to db while logging in
	    try{
				String id = null;
				Cookie[] cookies = request.getCookies();
				if(cookies !=null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("User_id")) id = cookie.getValue();
				}
				}
				//Parsing string user id to Integer
				Integer userId = Integer.parseInt(id);
				
			
				
				
				UserProfileDb user = new UserProfileDb();
				userObj = user.fetch_user(userId);
				
				//creating cookie to store emailid of user so that it can be used in update user jsp once the page refreshes
				Cookie emailCookie = new Cookie("emailid",userObj.getEmailid());
				

				//setting cookie to expiry in 30 mins
				emailCookie.setMaxAge(30*60);
				
				//setting values to response and request
				
				response.addCookie(emailCookie);
				
				request.setAttribute("user_info", userObj);
				

				//redirecting to respective page
				RequestDispatcher rd=request.getRequestDispatcher("updateprofile.jsp");            
				rd.include(request, response);	
			

		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	//Post method for update profile
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		//creating list for storing user info
		ArrayList<String> list = new ArrayList<String>();
		
		// get request parameters for userID and password
		String pwd = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String confirm_password = request.getParameter("confirm-password");
		
		
		
		try{
			
		
        //Check for null values, password and email validation
		
		if (pwd.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || confirm_password.isEmpty()){
			request.setAttribute("null_error","The above fields are mandatory and cannot be left null!!");
			RequestDispatcher rd=request.getRequestDispatcher("/updateprofile.jsp");            
			rd.include(request, response);
		}
		else if (!pwd.equals(confirm_password)){
			
			request.setAttribute("password_error","Password don't match dawg!!");
			RequestDispatcher rd=request.getRequestDispatcher("/updateprofile.jsp");            
			rd.include(request, response);
		}
		else {
			
			//Getting user id of the user logged in from cookie
			String id = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("User_id")) id = cookie.getValue();
			}
			}
			//Parsing string user id to Integer
			Integer userId = Integer.parseInt(id);
			
            //Calling method to update user info into db
			
			UserProfileDb user = new UserProfileDb();
			
			//adding elements to list
			list.add(firstname);
			list.add(lastname);
			list.add(pwd);
			
			user.update_user(list, userId);
			
			//redirecting to respective page
			response.sendRedirect("updatesuccess.jsp");
			
		}
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	

}