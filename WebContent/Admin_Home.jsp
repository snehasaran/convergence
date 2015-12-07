<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*" import="java.util.*"
	import="controller.LoginServlet" import="model.AdminHome"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Home Page</title>
<link rel="stylesheet"
	href="https://bootswatch.com/cosmo/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js">
	
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
		<div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="View_Login.jsp">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<form name="Admin_Home" action="LoginServlet" method="post"
		class="form-horizontal">
		<div class="container-fluid ">
			<%
				String user_name = new String();
				user_name = request.getParameter("user_name");
			%>
			<h2 align="center">
				Welcome Admin,
				<%
				out.println(user_name);
			%>
			</h2>
			<!-- Sneha changes -->


			<!-- New buttons -->
			<div class="well well-sm">
				<div class="form-group">
					<label for="groupName" class="col-sm-2 control-label">Group
						Name</label>
					<div class="col-md-6">
						<input type="text" class="form-control"
							placeholder="Sample Group Name" name="txtGroupName"
							id="txtGroupName">
					</div>
				</div>


				<div class="form-group">
					<label for="groupDescr" class="col-sm-2 control-label">Group
						Description</label>
					<div class="col-md-6">
						<input type="text" class="form-control"
							placeholder="Sample Group Description" name="txtGroupDescr"
							id="txtGroupDescr">
					</div>
				</div>


			</div>
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="submit" class="btn btn-default" align="middle"
						name="subLogin" id="createGroup" value="Create">Create</button>
				</div>
			</div>

			<div class="well well-sm">
				<div class="form-group">
					<div class="col-lg-10">
						<div class="checkbox">
						
							<!-- Sneha changes below -->
							<%
								Integer i = 0;
								Integer j = 0;
								Integer count = 0;
								count = (Integer) request.getAttribute("count");
								String[] group_name = (String[]) request.getAttribute("group_name");
								group_name = (String[]) request.getAttribute("group_name");
								for (i = 0; i < count; i++) {
							%>
							<label> <input type='checkbox' id='<%=j%>'
								name='requests' value='<%=j%>'> 
								<% 	out.println(group_name[i]); %></label><br />
							<%
								j++;
								}

								System.out.println("value of i = " + i);
							%>

						</div>

					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="submit" class="btn btn-default" align="middle"
						name="subLogin" id="deactivateGroup" value="Deactivate">Deactivate</button>
				</div>
			</div>



			<!-- New buttons end here -->


			<!-- Sneha changes end -->


		</div>
	</form>
</body>
</html>