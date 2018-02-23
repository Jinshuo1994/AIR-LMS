<!doctype html>
<%@ page language="java" import="java.util.*"  import="air.vo.Course" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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

				<div class="panel panel-default panel-table">
            		<div class="panel-heading">
						
	                	<div class="row">
							

	    	             	<div class="col-md-3 col-md-offset-9 text-right">
	        	            	<a class="btn btn-sm btn-primary" href="admin_course_add.jsp">Add Course</a>
	            	      	</div>			
		
	                	</div>
              		</div>
<!-- form -->
<!-- (1/2) course list -->
              	<div class="panel-body" >

					
					<div class="row coursedelete text-right" role="form">
						<form class="form-inline" method="post" action="./DeleteCourse" data-toggle="validator">
							<div class="form-group mx-sm-3">
								<input type="courseid" class="form-control" id="inputCourseid" placeholder="Course id" name="courseid" required>
							</div>
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>

					</div>

	                <table class="table table-striped table-bordered table-list">
	           
	                  <thead class = "tablebar">
	                    <tr>
	                        <th width="15%">ID</th>
							<th width="25%">Location</th>
	                        <th width="60%">Name</th>
	                    </tr> 
	                  </thead>
	<%ArrayList<Course> list = (ArrayList<Course>)session.getAttribute("courseList");%>
	<% if(list!=null){for(Course c: list)
	   {%>
	                 	 <tbody class = "tablebody">
	                          <tr>
	                            <td><%=c.getCourse_id() %></td>
								<td><%=c.getCourse_loc() %></td>
    	                        <td><%=c.getCourse_name() %></td>
                          	</tr>
                          	<% 
	   } }else{%>
	   <thead class = "tablebar">
	                    	<tr>
	                        	<th width="60%"></th>
	                        	<th width="40%">Name</th>
	                    	</tr> 
	                  	</thead>
						<tbody class = "tablebody">
							<tr>No Course</tr>
		
		<%} %>
	
                        	</tbody>
                	</table>
	            
	              </div>

	              <div class="panel-footer">

	              </div>
	            </div>

				
   			</div>
   	  	</div>
		
	</div>

</body>
</html>
