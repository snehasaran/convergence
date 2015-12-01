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

	<form name="Admin_Home" action="LoginServlet" method="get"
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
			<div class="well well-sm">
				<div class="form-group">
					<label class="col-lg-2 control-label">Admin Dashboard</label>
					<div class="col-lg-10">
						<div class="checkbox">
							<%
								Integer i = 0;
								Integer j = 0;
								Integer count = 0;
								count = (Integer) request.getAttribute("count");
								String[] first_name = (String[]) request.getAttribute("first_name");
								String[] group_name = (String[]) request.getAttribute("group_name");
								first_name = (String[]) request.getAttribute("first_name");
								group_name = (String[]) request.getAttribute("group_name");
								for (i = 0; i < count; i++) {
							%>
							<label> <input type='checkbox' id='<%=j%>'
								name='requests' value='<%=j%>'> <%
 	out.println(first_name[i] + " requests approval for " + group_name[i]);
 %></label><br />
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
						name="subAdd" id="subAdd" value="Add">Add</button>
					<button type="submit" class="btn btn-primary" align="middle"
						name="subReject" id="subReject" value="Reject">Reject</button>
				</div>
			</div>

			<!-- Sneha changes end -->

			<%-- <table id="alignment" border="0" align="center">
				<%
				Integer i = 0;
				Integer j = 0;
				Integer count = 0;
				count = (Integer) request.getAttribute("count");
				String[] first_name = (String[]) request.getAttribute("first_name");
				String[] group_name = (String[]) request.getAttribute("group_name");
				first_name = (String[]) request.getAttribute("first_name");
				group_name = (String[]) request.getAttribute("group_name");
				for (i = 0; i < count; i++) {
			%>
				<tr>
					<td><input type='checkbox' id='<%=j%>' name='requests'
						value='<%=j%>'> <%
						out.println(first_name[i] + " requests approval for " + group_name[i]);
					%></td>

				</tr>
				<%
				j++;
				}

				System.out.println("value of i = " + i);
			%>

				<tr>
					<td><input type="submit" name="subAdd" align="middle"
						id="subAdd" value="Add"> <input type="submit"
						name="subReject" align="middle" id="subReject" value="Reject">


						<button type="submit" class="btn btn-default" align="middle"
							name="subAdd" id="subAdd" value="Add">Add</button>

						<button type="submit" class="btn btn-default" align="middle"
							name="subReject" id="subReject" value="Reject">Reject</button></td>
				</tr>

			</table> --%>
		</div>
	</form>
</body>
</html>