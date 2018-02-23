<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="dist/js/validator.js"></script>
	
	<title>AiR User Main</title>
	
	<style>

	</style>
</head>

<body>
	<div class="container-fluid">	
		
<!--head(?)!-->
		<div class="row col-md-10 col-md-offset-1 head">
			<div class = "col-md-1 main"> 
				<a class="btn btn-default" href="studentmain.jsp" role="button">Main</a>
			</div>
			<div class = "col-md-4 col-md-offset-3">
				<div class="text-center"><img src="assets/logo2.png" width="162" height="55"></div>
			</div>
			<div class = "col-md-1 col-md-offset-3 logout">
				<a class="btn btn-default" href="login.jsp" role="button">Logout</a>
			</div>
		</div>
		
<!--Form!-->
<!--Should get Course name and Description-->
		<div class = "row col-md-10 col-md-offset-1 courselist">
			<div class="list-group">
  				<a href="student_coursemain.jsp?courseID=1" class="list-group-item list-group-item-action flex-column align-items-start">
					<div class="d-flex w-100 justify-content-between">
						<h5 class="mb-1">Course Name</h5>
    				</div>
    				<p class="mb-1">Description</p>
  				</a>
  				<a href="student_coursemain.jsp?courseID=2" class="list-group-item list-group-item-action flex-column align-items-start">
    				<div class="d-flex w-100 justify-content-between">
      					<h5 class="mb-1">Course Name</h5>
    				</div>
    				<p class="mb-1">Description</p>
  				</a>
  				<a href="student_coursemain.jsp?courseID=3" class="list-group-item list-group-item-action flex-column align-items-start">
	    			<div class="d-flex w-100 justify-content-between">
		      			<h5 class="mb-1">Course Name</h5>
	    			</div>
	    			<p class="mb-1">Description</p>
  				</a>
			</div>

		</div>

</div>

</body>
</html>
