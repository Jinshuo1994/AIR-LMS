<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="dist/js/validator.js"></script>
	
	<title>AiR Admin User</title>
	
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
					<li class="active"><a href="admin_user.jsp"><i class="menuuser"></i>User</a></li>
					<li><a href="admin_course.jsp"><i class="menucourse"></i>Course</a></li>
	            </ul>
			</div>			

			<div class="col-md-9 contents">
				<div class="panel panel-default panel-table">
            		<div class="panel-heading">
	                	<div class="row">
	    	              <div class="col col-md-6 col-md-offset-6 text-right">
							<button type="submit" class="btn btn-sm btn-primary">Save</button>
							<a class="btn btn-sm btn-default" href="admin_user.jsp">Cancel</a>
	            	      </div>
	                	</div>
              		</div>
              	<div class="panel-body">
<!--form!-->
	            some form to assign user
					
	              </div>
	              
	            </div>

				
   			</div>
   	  	</div>
		
	</div>

</body>
</html>
