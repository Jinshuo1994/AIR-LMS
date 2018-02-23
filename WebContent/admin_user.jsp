<!doctype html>
<%@ page language="java" import="java.util.*"  import="air.vo.User" pageEncoding="ISO-8859-1"%>
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
	 <base href="<%=basePath%>">
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

				<div class="panel panel-default panel-table" role="form">
            		<div class="panel-heading">
						
	                	<div class="row">
							<div class="col col-md-6 col-md-offset-6 text-right">
							</div>
	                	</div>
              		</div>
              		<div class="panel-body">
						<form method="post" action="./" data-toggle="validator">
	            		<table class="table table-striped table-bordered table-list">

							<thead class = "tablebar">
		                    	<tr>
		                        	<th width="40%"></th>
		                        	<th width="60%">Name</th>
		                    	</tr> 
		                  	</thead>
<%ArrayList<User> list = (ArrayList<User>)session.getAttribute("userList");%>
	<% if(list!=null){for(User u: list)
	   {%>
							<tbody class = "tablebody">
								<tr>
		                        	<td align="center">
										<div class="tableradio">
	  										<input type="radio" name="optradio" required>
										</div>
		                            </td>
									<td><%=u.getUserName() %></td>
								</tr>
	<% 
	   } }else{%>
							<thead class = "tablebar">
		                    	<tr>
		                        	<th width="40%"></th>
		                        	<th width="60%">Name</th>
		                    	</tr> 
		                  	</thead>
			
		<%} %>

							</tbody>
						</table>

						<div class="submitform text-right">
						<form method="post" action="./login" data-toggle="validator">
							<button type="submit" class="btn btn-sm btn-default">Assign Role</button>
							</form>
							<button type="submit" class="btn btn-sm btn-default">Add to Course</button>
							<button type="submit" class="btn btn-sm btn-danger">Remove from Course</button>
						</div>	
					</form>
				</div>
				
				<div class="panel-footer"></div>
           	  </div>

   			</div>
   	  	</div>
		
	</div>

</body>
</html>
