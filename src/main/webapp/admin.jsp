<%@page import="javax.sound.sampled.ReverbType"%>
<%@page import="servlet.AdminDb"%>
<%@page import="java.util.*"%>
<%@page import="servlet.ConnectionToDb"%>
<%@page import="servlet.Recipe"%>
<%@page import="servlet.User"%>
<%@page import="servlet.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FOODHACKS</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon" href="img/fav.png" type="image/png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"  href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="css/landingpage.css">
<link rel="stylesheet" type="text/css"  href="css/admin.css">


<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<%
//fetching name from cookie to display on top

String firstname = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("firstname")) firstname = cookie.getValue();
}
}
if(firstname == null) response.sendRedirect("login.jsp");
%>
<!-- Navigation
    ==========================================-->
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a href="#" class="navbar-left"><img src="./img/BrandLogo_resized.jpg"></a>
      <a class="navbar-brand page-scroll" href="#page-top">FOODHACKS</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#page-top" class="page-scroll">Home</a></li>
        
        <!-- The below links will redirect to different table details -->
        
        		<li><a href="#user_info" class="page-scroll">User</a></li> 
                <li><a href="#recipe_info" class="page-scroll">Recipe</a></li> 
                <li><a href="#review_info" class="page-scroll">Review</a></li> 
        

        <li><a href="logout.jsp" class="page-scroll">Logout</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

<!-- Navigation
    ==========================================-->
    

<!-- Header -->
<header id="header">
  <div class="intro">
    <div class="container">
      <div class="row">
        <div class="intro-text">
          <h1 >Welcome to Foodhacks <%=firstname %>!
          </h1>
          <p> Check below the database information!</p> </div> 
      </div>
    </div>
  </div>
  <br>
  <br>
  </header>  
<!-- Header -->  
  
<!--This part has pure css and html required as part of the project  -->   
<!-- Table contents -->  

<div id="user_info">
<!-- User Profile Table Content -->

<div class="table_fetch">
<h2>User Profile Table</h2>

<table>

  <tr>
    <th>User Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email Id</th>
    
  </tr>
  
  <tr>
	  <!-- Fetching User Information from User Profile table -->
	  <% AdminDb admin = new AdminDb();
	    ArrayList<User> al= admin.fetch_users();
	  
 for (User user: al){%>
	    
    <td><%=user.getUserId() %></td>
    <td><%=user.getFirstname() %></td>
    <td><%=user.getLastname() %></td>
    <td><%=user.getEmailid() %></td>
    
  </tr>
  <% }%>
 
</table>

</div>

<!-- Deleting a particular user entered by the admin -->

<div class="delete_element_table"> 
<form id="del_userid" action="AdminUserServlet" method="post" style="display: block;">
<div class="delete_element_text">
<label for="userid">Enter the user id you want to delete: </label>
<input class="input_text" type="text" name="userid" tabindex="1" placeholder="User Id" value="">
</div>
<div class="delete_element_btn">
<input type="submit" name="register-submit" class="btn-delete" tabindex="5" value="Delete">
</div>
 
 					<!-- For displaying error message if no user id entered -->
						<%
						String error=(String)request.getAttribute("null_error");
						if(error!=null)
						out.println("<font color=red size=4px>"+error+"</font>");
						%>  
					<!-- For displaying success message on deletion -->
						<%
						String success=(String)request.getAttribute("success");
						if(success!=null)
						out.println("<font color=green size=4px>"+success+"</font>");
						%>  
						
					<!-- For displaying error message on inappropriate user id -->
						<%
						String format_error=(String)request.getAttribute("number_error");
						if(format_error!=null)
						out.println("<font color=red size=4px>"+format_error+"</font>");
						%>  
						
</form>
</div>

</div> 
<!-- End of user profile content -->

<div id="recipe_info">
<!-- Recipe Table Content -->

<div class="table_fetch">
<h2>Recipe Table</h2>

<table>

  <tr>
    <th>Recipe Id</th>
    <th>Recipe Name</th>
    <th>Recipe Description</th>
    
    
    
  </tr>
  
  <tr>
	  <!-- Fetching Recipe Information from Recipe table -->
	  <% AdminDb admin2 = new AdminDb();
	    ArrayList<Recipe> al2= admin2.fetch_recipes();
	  
 for (Recipe recipe: al2){%>
	    
    <td><%=recipe.getRecipeId() %></td>
    <td><%=recipe.getRecipeName() %></td>
    <td><%=recipe.getRecipeDesc() %></td>
    
    
    
  </tr>
  <% }%>
 
</table>

</div>

<!-- Deleting a particular recipe entered by the admin -->

<div class="delete_element_table">
<form id="del_recipeid" action="AdminRecipeServlet" method="post" style="display: block;">
<div class="delete_element_text">
<label for="recipeid">Enter the recipe id you want to delete: </label>
<input class="input_text" type="text" name="recipeid" tabindex="1" placeholder="Recipe Id" value="">
</div>
<div class="delete_element_btn">
<input type="submit" name="register-submit" class="btn-delete" tabindex="5" value="Delete">
</div>
   
					<!-- For displaying error message if no recipe id entered -->
						<%
						String error2=(String)request.getAttribute("null_error2");
						if(error2!=null)
						out.println("<font color=red size=4px>"+error2+"</font>");
						%>  
					<!-- For displaying success message on deletion -->
						<%
						String success2=(String)request.getAttribute("success2");
						if(success2!=null)
						out.println("<font color=green size=4px>"+success2+"</font>");
						%>  
					<!-- For displaying error message on inappropriate recipe id -->
						<%
						String format_error2=(String)request.getAttribute("number_error2");
						if(format_error2!=null)
						out.println("<font color=red size=4px>"+format_error2+"</font>");
						%>  

</form>
</div>

</div>
<!-- End of Recipe content -->

<div id="review_info">
<!-- Review Table Content -->

<div class="table_fetch">
<h2>Recipe Review Table</h2>

<table>

  <tr>
    <th>Review Id</th>
    <th>Recipe Id</th>
    <th>User Id</th>
    <th>Review Date</th>
    <th>Recipe Review</th>    
    
  </tr>
  
  <tr>
	  <!-- Fetching Review Information from Review table -->
	  <% AdminDb admin3 = new AdminDb();
	    ArrayList<Review> al3= admin3.fetch_reviews();
	  
 for (Review review: al3){%>
	    
    <td><%=review.getReviewId() %></td>
    <td><%=review.getRecipeId() %></td>
    <td><%=review.getUserId() %></td>
    <td><%=review.getReviewdate() %></td>
    <td><%=review.getRecipeReview() %></td>
     
  </tr>
  <% }%>
 
</table>

</div>  

<!-- Deleting a particular recipe entered by the admin -->

<div class="delete_element_table">
<form id="del_reveiwid" action="AdminReviewServlet" method="post" style="display: block;">
<div class="delete_element_text">
<label for="reviewid">Enter the review id you want to delete: </label>
<input class="input_text" type="text" name="reviewid" tabindex="1" placeholder="Review Id" value="">
</div>
<div class="delete_element_btn">
<input type="submit" name="register-submit" class="btn-delete" tabindex="5" value="Delete">
</div>


					<!-- For displaying error message if no review id entered -->
						<%
						String error3=(String)request.getAttribute("null_error3");
						if(error3!=null)
						out.println("<font color=red size=4px>"+error3+"</font>");
						%>  
					<!-- For displaying success message on deletion -->
						<%
						String success3=(String)request.getAttribute("success3");
						if(success3!=null)
						out.println("<font color=green size=4px>"+success3+"</font>");
						%>  
					<!-- For displaying error message on inappropriate review id -->
						<%
						String format_error3=(String)request.getAttribute("number_error3");
						if(format_error3!=null)
						out.println("<font color=red size=4px>"+format_error3+"</font>");
						%>  
</form>
</div>

</div>

<!-- End of Review content -->

<div id="footer">
  <div class="container text-center">
    <div class="fnav">
      <p>Copyright &copy; Foodhacks. Designed by <a href="" rel="nofollow">TEAM 21</a>.</p>
    </div>
  </div>
</div>
<!-- JS for toggle menu RWD -->
<script type="text/javascript" src="js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="js/bootstrap.js"></script> 
<!--    JS for toggle in RWD(menu) -->
<!-- <script type="text/javascript" src="js/SmoothScroll.js"></script> 
<script type="text/javascript" src="js/nivo-lightbox.js"></script> 
<script type="text/javascript" src="js/jquery.isotope.js"></script> 
<script type="text/javascript" src="js/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="js/contact_me.js"></script> -->
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>