package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String email = request.getParameter("emailid");
		String pwd = request.getParameter("password");
	
		
		ConnectionToDb dobj = new ConnectionToDb();
		
		HashMap<String,String> map = dobj.user_info(email);
		try{
			
		if((!map.isEmpty()) && map.get("password").equals(pwd)){
			
			//creating cookie to store firstname and user_id
			Cookie loginCookie = new Cookie("firstname",map.get("firstname"));
			Cookie useridCookie = new Cookie("User_id",map.get("User_id"));

			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			useridCookie.setMaxAge(30*60);
			
			
			response.addCookie(loginCookie);
			response.addCookie(useridCookie);

		    response.sendRedirect("landingpage.jsp");


		}else{
			
			// display error message on the screen in case of incorrect credentials and redirecting to the same login page
			
			request.setAttribute("error","Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");            
			rd.include(request, response);
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}