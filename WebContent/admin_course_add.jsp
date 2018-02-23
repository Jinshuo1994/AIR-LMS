<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
    <script src="dist/js/bootstrap.min.js"></script>
    <script src="dist/js/validator.js"></script>
	
	<title>AiR Admin Course</title>
	
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
					<li><a href="admin_user.jsp"><i class="menuuser"></i>User</a></li>
					<li class="active"><a href="admin_course.jsp"><i class="menucourse"></i>Course</a></li>
	            </ul>
			</div>			

			<div class="col-md-9 contents">
				<div class="panel panel-default panel-table" role="form">
            		<div class="panel-heading">
	                	<div class="row">
	    	              <div class="col col-md-6 col-md-offset-6 text-right">

	            	      </div>
	                	</div>
              		</div>
              		<div class="panel-body">
<!--form!-->
<!-- form about course : name, Id -->
	            	<form method="post" action="./CreateCourse" data-toggle="validator">
						<h3>Enter Course Information</h3>
						  <div class="form-group">
							  <label for="coursename">Course Name</label>
							  <input type="name" class="form-control" id="InputCourseName" name="coursename" required>
						</div>
						<div class="form-group">
							  <label for="courseid">Course ID</label>
							  <input type="id" class="form-control" id="InputCourseid" name="courseid" required>
						</div>
						<div class="form-group">
							  <label for="courseloc">Location</label>
							  <input type="loc" class="form-control" id="InputCourseLoc" name="courseloc" required>
						</div>
						
						<div class="submitform text-right">
							<button type="submit" class="btn btn-sm btn-primary">Save</button>
							<a class="btn btn-sm btn-default" href="admin_course.jsp">Cancel</a>
						</div>
					</form>
					
	              	</div>
	              
	            </div>

				
   			</div>
   	  	</div>
		
	</div>

</body>
</html>
