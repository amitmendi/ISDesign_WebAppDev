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
<link rel="stylesheet" type="text/css"  href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>

</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
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
        <li><a href="#about" class="page-scroll">AboutUs</a></li>
        <li><a href="#quickrecipes" class="page-scroll">Quick Recipes</a></li>
        <li><a href="#contact" class="page-scroll">Contact</a></li>
        <li><a href="loginsignup.jsp" class="page-scroll">Login/SignUp</a></li>
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
          <h1>FOODHACKS</h1>
          <p> Are You Hungryy?  ChefCoco is here to make your cooking experience fun!   </p>
          <a href="#about" class="btn btn-custom btn-lg page-scroll">Learn More</a> 
          
         
       </div>
      </div>
    </div>
  </div>
</header>
<!-- About Section -->
<div id="about">
  <div class="container">
    <div class="section-title text-center center">
      <h2 style="color:#E87B07;">About Us</h2>
      <hr>
    </div>
    <div class="row">
      <div class="col-xs-12">
      
          <p class="lead">Food Hacks comes to the rescue of hardworking college students and working professionals who grimace at eating outside food every day and crave for some simple, home-cooked food. Food Hacks, a unique recipe sharing, and viewing app provides simple, quick and delicious recipes for people with busy lives. The app lists recipes for dishes that can be cooked in less than 15 minutes! The recipes are carefully crafted such that they utilize fewer ingredients, thus, reducing the need for frequent grocery shopping.</p>
         
         <div class="row aboutus-content">

      <div class="left-side">

        <div class="step" step-item="1">

          <h5>Sign Up/Login</h5>

          <p>It's free! Login Using Credentials.</p>
            
        </div>
            </div> <!-- left side -->
         <div class="step-2">
   
        <div class="step" step-item="2">

          <h5>Browse Recipes</h5>

          <p>Scroll through signature recipes by Chef Coco</p>
            
        </div>
          </div> <!-- step-2 -->

          <div class="step-3">
  
            <div class="step" step-item="3">

               <h5>Upload Recipes</h5>

               <p>Share yours and comment on other's recipes</p>
                  
            </div>

           </div> <!-- step-3 -->

            <div class="right-side">

            <div class="step" step-item="4">

               <h5>Start Cooking</h5>

               <p>Start cooking a healthy and sumptuous meal</p>
                  
            </div>
         </div><!-- right-side -->
          
          </div> <!-- /aboutus-content --> 
      </div>
    </div>
  </div>
</div>
<!-- Quick Recipes Section -->
<div id="quickrecipes">
 
 <div class="row section-intro">
      <div class="col-twelve " align="left">
        
        <h2 style="color: white; font-weight:bold;" >Are you Hungry?</h2>
            <h3 style="color: white">Here are our top picks for today...<h3>
  
      </div>      
    </div>
    <div class="item" data-item="1">

          <h2 style="color:white; margin-left:2em;" align="left">Quick Breakfast Recipes</h2>
      
          <ul>
            <li>
              <h2 style="color:white">Thai Peanut Noodles </a></h2>  <!-- reference https://www.favfamilyrecipes.com/two-minute-thai-peanut-noodles/ -->  
              <p>These noodles are super tasty and takes about 2-5min to prepare. Simply turn your ramen noodles into authentic Thai Noodles with a few easy steps. </br> 
              <span ><a style="color:white" href="https://www.favfamilyrecipes.com/two-minute-thai-peanut-noodles/" >View Recipe</a> </span></p> 
            </li>
            <li>
              <h2 style="color:white">Black Bean Soup</a></h2>
              <p>A perfect soup for a chilly night. With some garlic, onion and bell peppers you can prepare this healthy and filling soup within 10 minutes.</br>
              <a style="color:white" href="https://www.youtube.com/watch?v=iKqSZcCl3g0">View Recipe</a></p>
            </li>
            <li>
              <h2 style="color:white">Chicken Tacos</a></h2>
              <p>A very easy stir fry recipe for making mouth watering chicken tacos. You just need chicken, onions and some seasoning for this yummy dish.</br>
              <a style="color:white" href="https://www.youtube.com/watch?v=egt4UMjDGRM">View Recipe</a></p>
               </li>
          </ul>


      </div>

</div>








<!-- Contact Section -->
<div id="contact" class="text-center">
  <div class="container">
    <div class="section-title center">
      <h2>Get In Touch With Us</h2>
      <hr>
    </div>
    <div class="col-md-8 col-md-offset-2">
      <form name="sentMessage" id="contactForm" novalidate>
        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
              <input type="text" id="name" class="form-control" placeholder="Name" required="required">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-group">
              <input type="email" id="email" class="form-control" placeholder="Email" required="required">
              <p class="help-block text-danger"></p>
            </div>
          </div>
        </div>
        <div class="form-group">
          <textarea name="message" id="message" class="form-control" rows="4" placeholder="Message" required></textarea>
          <p class="help-block text-danger"></p>
        </div>
        <div id="success"></div>
        <button type="submit" class="btn btn-default btn-lg">Send Message</button>
      </form>
      <div class="social">
        <ul>
          <li><a href="http://fb.me/FoodHacks21" target="blank"><i class="fa fa-facebook"></i></a></li>
          <li><a href="https://twitter.com/FoodHacks6" target="blank"><i class="fa fa-twitter"></i></a></li>
          <li><a href="https://instagram.com/foodhacks21?utm_source=ig_profile_share&igshid=1casd7ql5mdys" target="blank"><i class="fa fa-instagram"></i></a></li>
        
        </ul>
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