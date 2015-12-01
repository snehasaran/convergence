<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.DBDemo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
<link rel="stylesheet"
	href="https://bootswatch.com/cosmo/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js">
		function validate()
		{
			var x=document.forms["LoginForm"]["txtUserName"].value;
			
			if(x==null || x=="")
				{
				alert("Please enter a username.");
				return false;
				}	
			else
		{
				return validatepwd(document.forms["LoginForm"]["txtPassword"].value);
		}
				
		}
		function validatepwd(pwd)
		{
			if(pwd==null || pwd=="")
				{
				alert("Please enter a password.");
				return false;
				}
			
		}
		
		
		
		</script>
</head>
<body class>

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Convergence</a>
		</div>
	</div>
	</nav>
	<% String value = new String();
			value = request.getParameter("chkuser");
			System.out.println("value = " + value);
			%>
	<% 
			if (value!= null)
				{
				if (value.equals("true"))
				{
				out.println("Wrong username and password, please try again!"); 
				}
				}
			%>

	<form name="LoginForm" action="LoginServlet" method="post"
		class="form-horizontal">
		<div class="container-fluid">
			<div class="form-group ">
				<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
				<div class="col-md-6">
					<input type="text" class="form-control" placeholder="Username"
						name="txtUserName" id="txtUserName">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-md-6">
					<input type="password" class="form-control" name="txtPassword"
						id="txtPassword" placeholder="Password">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" name="subLogin"
						id="subSubmit" value="Login" onclick="return validate();">Sign
						in</button>
				</div>
			</div>
		</div>
	</form>

</body>
</html>