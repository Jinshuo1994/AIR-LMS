<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AiR Signup</title>
<script src="jquery-3.2.1.js"></script>
<link rel="stylesheet" href="dist/css/bootstrap.min.css">
<script src="dist/js/bootstrap.min.js"></script>

<script src="dist/js/validator.js"></script>
<style>
.loginform {
	margin-top: 60px;
}

.footer {
	border-top: 1px solid gray;
	padding: 23px 0 12px 0;
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

	<!--Signup Form-->
	<div class="container-fluid">
		<div class="col-md-4 col-md-offset-4 loginform" role="form">
			<div class="text-center">
				<img src="assets/logo.png" width="250" height="163">
			</div>
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong> Signup </strong>
				</div>
				<div class="panel-body">
					<!--To do: change to Log in Servlet path!-->
					<form method="get" action="./signup" data-toggle="validator">
						<div>
							<%
								if (request.getParameter("success") != null) {
							%>
							<div class="alert alert-success" role="alert">
								<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
								<span class="sr-only">Error:</span> Done! Redirecting in <span id="showTime"></span>
								seconds...
							</div>
							<script>
								var cnt = 3;
								window.setInterval(function() {
									if (cnt < 0) {
										window.location.href = "./login.jsp";
									} else {
										document.getElementById("showTime").innerHTML = "<font color=blue >" + cnt + "</font>";
										cnt--;
									}
								}, 1000);
							</script>
							<%
								}
							%>
						</div>

						<div>
							<%
								if (request.getParameter("error") != null) {
							%>
							<div class="alert alert-danger" role="alert">
								<span class="glyphicon glyphicon-exclamation-sign"
									aria-hidden="true"></span> <span class="sr-only">Error:</span>
								The account has already been registered! Please use another one!
							</div>
							<%
								}
							%>
						</div>


						<div class="form-group">
							<label for="InputUsername">Username</label> <input type="text"
								class="form-control" id="InputUsername" name="username"
								placeholder="Enter Username" required>
						</div>

						<div class="form-group">
							<label for="InputPassword">Password</label> <input
								type="password" class="form-control" data-minlength="5"
								id="InputPassword" name="password" placeholder="Enter Password"
								required>
							<div class="help-block">Your password must contain at least
								5 characters</div>
						</div>

						<div class="form-group">
							<label for="ConfirmPassword">Confirm Password</label> <input
								type="password" class="form-control" id="ConfirmPassword"
								data-match="#InputPassword"
								data-match-error="The passwords do not match."
								placeholder="Confirm password" required>
						</div>

						<button type="submit" class="btn btn-dark">Sign Up</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>