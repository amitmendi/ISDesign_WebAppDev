package servlet;

import java.io.IOException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/StoreReviewServlet")
public class StoreReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//fetch and store recipe and review values stored in recipereview  jsp once the page refreshes
		
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
				
					//fetching review and user info who posted the review from db by joining user and review table

					ReviewDb rev = new ReviewDb();
					ArrayList<Review> revList = rev.fetch_review(rec.getRecipeId());
					
					//setting recipe object to request
					request.setAttribute("recipe", rec);
					//setting review object list to request
					request.setAttribute("reviewList", revList);
		
		
		
		//creating list for storing reciew info
		ArrayList<Object> list = new ArrayList<Object>();
		
		// get request parameters
		String review = request.getParameter("review");
		Integer recipeId = Integer.parseInt(request.getParameter("recipeId"));
		//String recipeId = request.getParameter("recipeId");
		
		//Getting date of review  
		
		Date reviewdate = new Date();
		
		
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
		
        //Check for null values

		if (review.isEmpty()){
			
			
			//setting error message
			
			request.setAttribute("null_error","Kindly post the review before submitting!!");
			RequestDispatcher rd=request.getRequestDispatcher("/recipeReview.jsp");            
			rd.include(request, response);
			
		
		
		}
		else{	
			ReviewDb dobj = new ReviewDb();
			
			//adding String elements to list to store in db
			list.add(userId);
			list.add(recipeId);
			list.add(reviewdate);
			list.add(review);
			
			dobj.store_review(list);
			
			//updating the review list to show the latest review if the review is posted successfully
			revList = rev.fetch_review(rec.getRecipeId());
			
			//overwriting review object list to request
			request.setAttribute("reviewList", revList);
			
			
			//redirecting to respective page
			request.setAttribute("success","The review has been posted successfully. Check below!!");
			RequestDispatcher rd=request.getRequestDispatcher("/recipeReview.jsp");            
			rd.include(request, response);	
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}