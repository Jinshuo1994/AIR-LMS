<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="dist/js/validator.js"></script>
	
	<title>AiR Admin Main</title>
	
	<style>
	</style>
</head>

<body>
	<div class="container-fluid">	
<!--head(?)!-->
		<div class="row col-md-10 col-md-offset-1 head">
			<div class = "col-md-1 main"> 
				<a class="btn btn-default" href="adminmain.jsp" role="button">Main</a>
			</div>
			
			<div class = "col-md-4 col-md-offset-3">
				<div class="text-center"><img src="assets/logo2.png" width="162" height="55"></div>
			</div>
			
			<div class = "col-md-1 col-md-offset-3 logout">
				<a class="btn btn-default" href="login.jsp" role="button">Logout</a>
			</div>
		</div>
<!-- menu !-->
		<div class = "row col-md-10 col-md-offset-1 page">
			<div class="col-md-2 menu">
				<ul class="nav nav-default nav-pills nav-stacked">
					<li><a href="./DisplayAllUser"><i class="menuuser"></i>User</a></li>
					<li><a href="./DisplayCourse"><i class="menucourse"></i>Course</a></li>
	            </ul>
			</div>			

			<div class="col-md-9 contents">
<!--form!-->
<!--Not sure what to do with here-->
            	<p><h1>Hi,</h1></p>
				<p><h5>You can easily manage the system with AiR!</h5></p>
        	</div>
   	  </div>
</div>

</body>
</html>
