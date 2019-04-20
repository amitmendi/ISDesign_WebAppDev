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
@WebServlet("/RecipeReviewServlet")
public class RecipeReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		//creating Class Object for storing recipe info
		Recipe rec = new Recipe();
		
		// get request parameters for recipe and add them to class object
	
			//adding elements to class object
			rec.setRecipeName(request.getParameter("recipeName"));
			rec.setRecipeId(Integer.parseInt(request.getParameter("recipeId")));
			rec.setRecipeDesc(request.getParameter("recipeDesc"));
			rec.setImgUrl(request.getParameter("recipeUrl"));
			rec.setRecipeSteps(request.getParameter("recipeSteps" ));

			rec.setRecipeIng(request.getParameter("recipeIng"));
			
			
//			//fetching user id from cookie object
//			
//			String User_id = null;
//			Cookie[] cookies = request.getCookies();
//			if(cookies !=null){
//			for(Cookie cookie : cookies){
//				if(cookie.getName().equals("User_id")) User_id = cookie.getValue();
//			}
//			}
//			System.out.println(User_id);
//			if(User_id == null) response.sendRedirect("landingpage.jsp");
			

			//fetching review and user info who posted the review from db by joining user and review table

			ReviewDb rev = new ReviewDb();
			ArrayList<Review> revList = rev.fetch_review(rec.getRecipeId());
			
			
			//setting recipe object to request
			request.setAttribute("recipe", rec);
			//setting review object list to request
			request.setAttribute("reviewList", revList);
		

			
			//redirecting to respective page

			RequestDispatcher rd =  request.getRequestDispatcher("recipeReview.jsp"); 
			rd.include(request, response); 
			
			}
		
		
		
		
	

}