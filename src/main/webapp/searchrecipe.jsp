<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlet.Recipe"%>
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
<link rel="stylesheet" type="text/css"  href="css/style.css">
<link rel="stylesheet" type="text/css"  href="css/searchrecipe.css">


<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
<!-- <script type="text/javascript" src="js/modernizr.custom.js"></script>
 -->
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>  



</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
  
<!-- Fetching recipe data from request object -->

<% 
   ArrayList<Recipe> recList = (ArrayList<Recipe>) request.getAttribute("recipeList");
   String recipe_searched = (String) request.getAttribute("recipe_searched");
   %>
  	
  
  
<!-- Navigation
    ==========================================-->
<nav id="menu" class="navbar navbar-default navbar-fixed-top on">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a href="#" class="navbar-left"><img src="./img/BrandLogo_resized.jpg"></a>
      <a class="navbar-brand page-scroll" href="#page-top">FOODHACKS</a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="landingpage.jsp" class="page-scroll">Home</a></li>
        <li><a href="logout.jsp" class="page-scroll">Logout</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

<div id="results" >
<div class="result-container">

    <hgroup class="mb20">
    <h1>Search Results</h1>
    <h2 class="lead"><strong class="text-danger"><%=recList.size() %></strong> results were found for <strong class="text-danger"><%=recipe_searched %></strong></h2>               
  </hgroup>
 
 <!-- This section shows recipe information fetched from db based on user input -->
    <!-- Iterating the recipe list fetched from request object -->
    <%for (Recipe rec: recList) {%>
    <section class="col-xs-12 col-sm-6 col-md-12">
    <article class="search-result row">
      <div class="col-xs-12 col-sm-12 col-md-3">
        <img class ="thumbnail" src="<%=rec.getImgUrl() %>" alt="Recipe Image" /> 
      </div>
      
      <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
        <h3><%=rec.getRecipeName() %></h3>
        <p><%=rec.getRecipeDesc() %></p>     
        
        <!-- Creating form with hidden fields to send to the next servlet call: to show the full recipe information  -->      
       
        <form id="Recipe-form" action="RecipeReviewServlet" method="post" style="display: block;">
        		
        		<input type="hidden" name="recipeId" value = "<%=rec.getRecipeId()%>" >
        		<input type="hidden" name="recipeName" value = "<%=rec.getRecipeName()%>" >
     			<input type="hidden" name="recipeUrl" value = "<%=rec.getImgUrl()%>" >
     			<input type="hidden" name="recipeDesc" value = "<%=rec.getRecipeDesc()%>" >
     			<input type="hidden" name="recipeSteps" value = "<%=rec.getRecipeSteps()%>" >
     			<input type="hidden" name="recipeIng" value = "<%=rec.getRecipeIng()%>" >
                <button type ="submit" class="btn btn-primary">View recipe</button>
        </form>
      </div>
      <span class="clearfix borda"></span>
    </article>
    </section>
    <% }%>
  
</div>

</div>
<!-- Footer Section -->
<div id="footer">
<div class = "searchrecipe-footer">
    <div class="fnav">
      <p>Copyright &copy; Foodhacks. Designed by <a href="" rel="nofollow">TEAM 21</a>.</p>
    </div>
</div>
</div>
<!--    JS for toggle menu (RWD) -->
<script type="text/javascript" src="js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="js/bootstrap.js"></script> 

<script type="text/javascript" src="js/main.js"></script> 
</body>
</html>