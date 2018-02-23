<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="dist/js/validator.js"></script>
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	<title>AiR Welcome</title>
	
	<style>
		.loginform {
            margin-top:60px;
        }
		body { 
 			background: url(assets/bg.jpg) no-repeat center center fixed; 
    		width: 100%;
    		height: 100%;
    		background-size: cover;
    		overflow: hidden;
		}
		
	</style>
</head>
	
<body>
<!--Login Form-->
<div class="container-fluid">
	<div class="col-md-4 col-md-offset-4 loginform" role="form">
		<div class="text-center"><img src = "assets/logo.png" width="250" height="163"></div><br>
		<div class="panel panel-default">
  			<div class="panel-heading"><strong> Sign In </strong></div>
  			<div class="panel-body">
            <!--To do: change to Log in Servlet path!-->
        <form method="post" action="./login" data-toggle="validator">
 				<div>
        			<%
	        			if(request.getParameter("error") != null && request.getParameter("error").equals("recaptchaError")) {
	        		%>
					<div class="alert alert-danger" role="alert">
 					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  					<span class="sr-only">Error:</span>
  					Fail to verify captcha! Try it again!
					</div>
	        		<%
	        			}
        			%>
        			</div>
 				
 				<div>
        			<%
	        			if(request.getParameter("error") != null && request.getParameter("error").equals("loginError")) {
	        		%>
					<div class="alert alert-danger" role="alert">
 					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  					<span class="sr-only">Error:</span>
  					Username or password error. Please check it again!!!
					</div>
	        		<%
	        			}
        			%>
        			</div>
        			
                <div class="form-group">
                    <label for="InputUsername">Username</label>
                    <input type="text" class="form-control" id="InputUsername" name="username" placeholder="Enter Username" required>
                </div>
                <div class="form-group">
                    <label for="InputPassword">Password</label>
                    <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Enter Password" required>
                </div>
                <div class="form-group">
     				<div class="g-recaptcha" data-sitekey="6LfAezsUAAAAAGT9KlPk4L7_2ivAcJ4TzzBgLsYe"></div>
     			</div>

                <!--To do: change signup.html to signup.jsp!-->
                <button type="submit" class="btn b	tn-dark">Log In</button>
				<div class="form-group">
					<div class="col-md-12 control">
						<div style="padding-top:20px; font-size:90%">Don't have an account? 
                                       <a href="signup.jsp">Sign Up</a>
						</div>
					</div>
				</div>  
		</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
