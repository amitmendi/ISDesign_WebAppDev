<%@page import="servlet.Review"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" type="text/css"  href="css/recipeReview.css">

<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>



<script type="text/javascript" src="js/jquery.1.11.1.js"></script> 
<script type="text/javascript" src="js/bootstrap.js"></script> 
<script type="text/javascript" src="js/SmoothScroll.js"></script> 
<script type="text/javascript" src="js/nivo-lightbox.js"></script>
<script type="text/javascript" src="js/jquery.isotope.js"></script> 
<!-- <script type="text/javascript" src="js/jqBootstrapValidation.js"></script>  -->
<!-- <script type="text/javascript" src="js/contact_me.js"></script>  -->
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/View_recipe.js"></script>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Fetching recipe data from request object -->

<% Recipe rec = (Recipe)request.getAttribute("recipe");
   ArrayList<Review> revList = (ArrayList<Review>) request.getAttribute("reviewList");
   
   //splitting steps and ingredients by | operator
   String recipeSteps = rec.getRecipeSteps();
   String recipeIng = rec.getRecipeIng();
   String[] steps = recipeSteps.split("[|]",0);
   String[] ings = recipeIng.split("[|]",0);
   
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
        <li><a href="#page-top" class="page-scroll">Recipe</a></li>
                <li><a href="#review_section" class="page-scroll">Reviews</a></li>
        <li><a href="landingpage.jsp" class="page-scroll">Home</a></li>
        <li><a href="logout.jsp" class="page-scroll">Logout</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>
<div id="recipedetails" class="container">
    <div class="row" style="margin-top: 15%;">    
        <div class="col-md-8">
            <div class="card" style="background-color:#F9F9F9;">
                <!-- card image -->
                <div class="card-image">
                    <img class="img-responsive" src="<%=rec.getImgUrl() %>"> 
                </div>
                
                <div class="card-content">
                    <span class="card-title"><%=rec.getRecipeName()%></span>                    
                    <button type="button" id="show" class="btn btn-custom pull-right"aria-label="Left Align">
                        <!-- <i class="fa fa-ellipsis-v"></i> -->Show Recipe
                    </button>
                </div><!-- card content -->
                <div class="card-action">
                    <ul id="recipe_prep_details">
                      <li><b>Prep time:</b> 5min</li>
                    <li> <b>Serves:</b> 2</li>     
                    <li><b>Cooking time:</b>10min</li>
                    </ul>            
                </div><!-- card actions -->
                <div class="card-reveal">
                  <span class="card-title">Steps And Ingredients </span> <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">close</span></button>
                    <p class="ingredient_list">List of ingredients: </p>
                    <p>
                       <ul>
                        <%for (String ing: ings){%>
                        <li><%out.println(ing); %></li>
                        <% }%>
                       </ul>
                    </p>
                    <p class="ingredient_list">Follow the steps below: </p>
                    <p>                        
                       <ul>
                        <%for (String step: steps){%>
                        <li><%=step %></li>
                        <% }%>
                       </ul>
                    </p>
                </div><!-- card reveal -->
            </div>
        </div>
        <div id="message"class="col-md-3 col-md-offset-1 ">
            <div class="card">
               <div class="card-image">
                    <img class="img-responsive" src="./img/chef-igotthis.jpg"> 
                    <div class="card-action">
                    <p class="message_greeting"><b> Don't worry! Chef Coco is here to help you.</b></p>            
                </div><!-- card actions -->
                    
                </div><!-- card image -->
            </div>
          </div>
    </div>
</div>
<!-- Review Section -->
<div id="review_section">
<div class="row bootstrap snippets">
    <div id="review_column" class="col-md-8 ">   <!-- for normal width use: "col-md-6 col-md-offset-1 col-sm-12" -->
        <div class="comment-wrapper">
            <div class="panel panel-info">
                <div class="panel-heading">
                    Reviews
                </div>
                <div class="panel-body">
                
                <!-- Form to store review in db -->
                
                <form id="Review-form" action="StoreReviewServlet" method="post" style="display: block;">

                  <input type="hidden" name="recipeId" value = "<%=rec.getRecipeId()%>" >
                    <!--  Code to see if above recipe and review list objects are null in case the page refreshes since data is coming from other servlet
  
                   First setting above values of recipe to hidden fields -->
 
                    <input type="hidden" name="recipeName" value = "<%=rec.getRecipeName()%>" >
                    <input type="hidden" name="recipeUrl" value = "<%=rec.getImgUrl()%>" >
                    <input type="hidden" name="recipeDesc" value = "<%=rec.getRecipeDesc()%>" >
                    <input type="hidden" name="recipeSteps" value = "<%=rec.getRecipeIng()%>" >
                    <input type="hidden" name="recipeIng" value = "<%=rec.getRecipeSteps()%>" >
                      
                      <!--  For reviewlist call fetch recipe again this servlet using recipe id -->

                    <textarea name="review" class="form-control" placeholder="write a comment..." rows="3"></textarea>
                    <br>
                    <button type="submit" id ="submit_review" class="btn btn-custom pull-right">Post Review</button>
                </form>


                  <!-- For displaying error message on no review -->
                    <%
                    String null_review=(String)request.getAttribute("null_error");
                    if(null_review!=null)
                    out.println("<font color=red size=4px>"+null_review+"</font>");
                    %>
                    <!-- For displaying success message on review post success -->
                    <%
                    String success=(String)request.getAttribute("success");  
                    if(success!=null)
                    out.println("<font color=green size=4px>"+success+"</font>");
                    %>

                    <div class="clearfix" style="height: 4em;"></div>
                    <hr>
                    <ul class="media-list">
                        <li class="media">
                            <a href="#" class="pull-left"><!-- 
                                <img src="https://bootdey.com/img/Content/user_1.jpg" alt="" class="img-circle"> -->
                            </a>
                            <div class="media-body">
                                <span class="text-muted pull-right">
                                </span>
                                <%if (revList.isEmpty()) {
                                	out.println("No review posted yet. Be the first one to post!!");
                                	}
                                  else {
                                 	for (Review rev: revList) {%>
                                 	
                                <strong class="text-success">@<%=rev.getFirstname()%></strong>
                                <p><%=rev.getRecipeReview()%></p>	
                                 <% }
                                 }%>

                            </div>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>
</div> <!-- review section end-->
<!-- Review end -->

<div id = "maylike">
<h2>You may also like:  </h2>
<div class="row">
        <div class="col-sm-4">
          <div class="card" style="width:312px;">
          <img class="card-img-top" src="./img/beef-tacos.jpg" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title">Beef Tacos</h5>
              <p class="card-text">"A sumptutous meal consisting of beef, chilli and sowthwest tortilla."</p>
              <a href="https://www.foodnetwork.com/recipes/ree-drummond/beef-tacos-2632842" target="blank" class="btn btn-primary">View Full Recipe</a>
            </div>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="card" style="width:312px;">
          <img class="card-img-top" src="./img/beef-enchillada.jpg" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title">Beef Enchilada</h5>
              <p class="card-text">"A tasty and filling meal with some cheese and beans"</p>
              <a href="https://www.gimmesomeoven.com/beef-enchiladas-recipe/" target="blank" class="btn btn-primary">View Full Recipe</a>
            </div>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="card" style="width:312px;">
          <img class="card-img-top" src="./img/ChickenSoup.jpg" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title">Chicken Soup</h5>
              <p class="card-text">"This healthy soup will take you all the way through winter"</p>
              <a href="https://www.delish.com/cooking/recipe-ideas/a19992009/spring-chicken-soup-recipe/" traget="blank" class="btn btn-primary">View Full Recipe</a>
            </div>
          </div>
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

</body>
</html>