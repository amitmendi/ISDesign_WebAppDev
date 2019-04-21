<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="servlet.User"%>
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
<link rel="stylesheet" type="text/css"  href="css/login.css">
<link rel="stylesheet" type="text/css"  href="css/style.css">

<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>  <!-- code.jquery.com/jquery-1.11.1.min.js-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<% 
//fetching name from cookie to display on top
String firstname = null;
String email=null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("firstname")) firstname = cookie.getValue();
	else if(cookie.getName().equals("emailid")) email = cookie.getValue();
}
}


//fetching user info from request object

User user = (User)request.getAttribute("user_info");

// condition when the page refreshes

String fname="Firstname";
String lname="Lastname";


if (user!=null){
 fname = user.getFirstname();
 lname = user.getLastname();
 email = user.getEmailid();
}

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
    </div>
  </div>
</header>
<div id="fullscreen_bg" class="fullscreen_bg"/>
<div id="regContainer" class="container">
  <br>
  <br>
  <br>
    <h1 align="center"style="margin-top: 10%;color: white;">Welcome <%=firstname %>! </h1>
    <br>
      <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-login">
          <div class="panel-heading">
             <img align="center" width="20%" height="35%" src="./img/chefchopping.jpg">
            <div class="row">
              
              <div class="col-xs-12">
                <a href="#" id="register-form-link">Your Profile</a>
              </div>
            </div>
            <hr>
          </div>
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                
                <form id="register-form" action="UpdateProfileServlet" method="post" style="display: block;">
                  <div class="form-group">
                    <label for="firstname">First Name</label>
                    <input type="text" name="firstname" id="firstname" tabindex="1" class="form-control" placeholder="Firstname" value="<%=fname%>">
                  </div>
                  <div class="form-group">
                    <label for="lastname">Last Name</label>
                    <input type="text" name="lastname" id="lastname" tabindex="2" class="form-control" placeholder="Lastname" value="<%=lname%>">
                  </div>
                  <div class="form-group">
                    <label for="emailid">Emailid</label>
                    <input type="text" name="emailid" id="emailid" tabindex="3" class="form-control" placeholder="Email id" value="<%=email%>" readonly="true">
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" tabindex="4" class="form-control" placeholder="Use Old or Set New Password">
                  </div>
                  <div class="form-group">
                    <label for="confirm-password">Confirm Password</label>
                    <input type="password" name="confirm-password" id="confirm-password" tabindex="4" class="form-control" placeholder="Confirm Password">
                  </div>
                 
                   <%
						String password_msg=(String)request.getAttribute("password_error");  
						if(password_msg!=null)
						out.println("<font color=red size=4px>"+password_msg+"</font>");
				  %>
				  <%
						String null_msg=(String)request.getAttribute("null_error");  
						if(null_msg!=null)
						out.println("<font color=red size=4px>"+null_msg+"</font>");
				  %>
                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                        <input type="submit" name="register-submit" id="register-submit" tabindex="5" class="form-control btn btn-register" style="border: 0.2em solid black;" value="Update Profile">
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
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
<!--    JS for toggle in RWD(menu) -->
<script type="text/javascript" src="js/jquery.1.11.1.js"></script>  
<script type="text/javascript" src="js/bootstrap.js"></script> 
<!-- <script type="text/javascript" src="js/SmoothScroll.js"></script>
<script type="text/javascript" src="js/nivo-lightbox.js"></script>
<script type="text/javascript" src="js/jquery.isotope.js"></script>
<script type="text/javascript" src="js/jqBootstrapValidation.js"></script>  -->

<script type="text/javascript" src="js/main.js"></script>
</body>
</html>