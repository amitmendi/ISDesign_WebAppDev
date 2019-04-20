<%@page import="java.util.*"%>
<%@page import="servlet.ConnectionToDb"%>
<%@page import="servlet.Recipe"%>
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

<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<%
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
<!--         <li><a href="#about" class="page-scroll">AboutUs</a></li>
        <li><a href="#quickrecipes" class="page-scroll">Quick Recipes</a></li>
        <li><a href="#contact" class="page-scroll">Contact</a></li> -->
        <li><a href="login.jsp" class="page-scroll">Logout</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>
<!-- Header -->
<header id="header">
  <div class="intro">
    <div class="container">
      <div class="row">
        <div class="intro-text">
          <h1 >Welcome to Foodhacks <%=firstname %>!
          </h1>
          <p> Browse through our recipes...</p> </div> 
      </div>
    </div>
  </div>
  <br>
  <br>
    <!-- Actual search box -->
<div class="col-md-6 col-md-offset-3">     
<div class="row">

<form role="form" id="form-buscar" style="padding:1em; margin-top:-40%;">
<div class="form-group">
<div class="input-group">
<input id="1" class="form-control" type="text" name="search" placeholder="Start typing the name of your favourite dish..." required/>
<span class="input-group-btn">
<button class="btn btn-success" type="submit" style="background-color: #54D0DD;">
<!-- <i class="glyphicon glyphicon-search" aria-hidden="true"></i> --> Search
</button>
</span>
</div>
</div>

</form>
</div>            
</div>
  </header>  
  <br>


<div id="suggestions">
  <!-- <div class="container">
    <div class="section-title text-center center">
      <h2 style="color:#E87B07;">Here are Chef Coco's top suggestions for you..</h2>
      <hr>
    </div>
  </div> -->
  <div class="container">
    <div class="section-title text-center center">
      <h2 style="color:#E87B07;">Here are Chef Coco's top suggestions for you..</h2>
      <hr>
    </div>
    <div class="row">
    <%ConnectionToDb connDb = new ConnectionToDb();
    ArrayList<Recipe> al= connDb.fetchRecipes();
    int limit = 0;
    	for(Recipe rec: al){
        if (limit < 3){%>
        <div class="col-sm-4">
          <div class="card" style="width: 18rem; margin:2em;">
          <img class="card-img-top" src="<%=rec.getImgUrl() %>" alt="Card image cap" style="width:286px; height:190px;"> <!-- put inline intentionally to overwrite bootstrap css -->
            <div class="card-body">
              <h5 class="card-title"><%=rec.getRecipeName()%></h5>
              <p class="card-text"><%=rec.getRecipeDesc()%></p>

              <!-- new code for accessing full recipe info -->
              
              <!-- Making remaining attributes hidden so that they can be displayed on a different jsp -->
             
              
              
              <form id="Recipe-form" action="RecipeReviewServlet" method="post" style="display: block;">
               <div class="full-recipe">
                        <input type="hidden" name="recipeName" value = "<%=rec.getRecipeName()%>" >
                        <input type="hidden" name="recipeId" value = "<%=rec.getRecipeId()%>" >
                        <input type="hidden" name="recipeDesc" value="<%=rec.getRecipeDesc()%>">
                        <input type="hidden" name="recipeUrl" value="<%=rec.getImgUrl()%>">
                        <input type="hidden" name="recipeSteps" value="<%=rec.getRecipeSteps()%>">
                        <input type="hidden" name="recipeIng" value="<%=rec.getRecipeIng()%>">
     
                        <input type="submit" name="view_full_recipe" class="btn btn-primary" value="View Full Recipe">
               </div>
              </form> 
         


            </div>
          </div>
        </div><%
        limit++;}
      }  %>
    </div>
  </div>
</div>
<div id="footer">
  <div class="container text-center">
    <div class="fnav">
      <p>Copyright &copy; Foodhacks. Designed by <a href="" rel="nofollow">TEAM 21</a>.</p>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="js/bootstrap.js"></script> 
<script type="text/javascript" src="js/SmoothScroll.js"></script> 
<script type="text/javascript" src="js/nivo-lightbox.js"></script> 
<script type="text/javascript" src="js/jquery.isotope.js"></script> 
<script type="text/javascript" src="js/jqBootstrapValidation.js"></script> 
<script type="text/javascript" src="js/contact_me.js"></script> 
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>