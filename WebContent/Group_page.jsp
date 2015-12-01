<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*" import="java.util.*"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group Page</title>
<link rel="stylesheet"
	href="https://bootswatch.com/cosmo/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js">
function autoSize(ele)
{
   ele.style.height = 'auto';
   var newHeight = (ele.scrollHeight > 32 ? ele.scrollHeight : 32);
   ele.style.height = newHeight.toString() + 'px';
}


function callinsertservlet(value,post)
{
	alert("call comes here" + post  + value);
	var path= "InsertComments.jsp?group_id=<%=request.getParameter("group_id")%>&post_id="+ value+ "&post=" + post ;
	location.href=path;
}

function editpost(value)
{
	var changed_post = document.getElementById(value).value;
	alert("control comes here !! yeeee" + changed_post);
	document.location.href="updatepost?post_id=" + value +"&post=" + changed_post;
	//alert ("the call was successful");
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
		<div class="">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="View_Login.jsp">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<form name="Group_page" action="insert" method="post"
		class="form-horizontal">
		<div class="container-fluid ">

			<%
				//System.out.println("reached group page");
			%>
			<h2 align="center">
				Welcome to the
				<%
				out.println(request.getParameter("group_name"));
			%>
				page
			</h2>

			<%
				session.setAttribute("group_id", request.getParameter("group_id"));
				session.setAttribute("group_name", request.getParameter("group_name"));
			%>
			<%
				String group_id = new String();
				group_id = request.getParameter("group_id");
			%>

<!-- Sneha changes start here -->



<!-- Sneha changes end here -->



			<table id="alignment" align="center">
				<tr>
					<td>
						<%
							//System.out.println("MySQL Connect Example.");
							Connection conn = null;
							String url = "jdbc:mysql://localhost:3306/";
							String dbName = "hw5";
							String driver = "com.mysql.jdbc.Driver";
							String userName = "admin";
							String password = "";
							String post = new String();
							try {
								Class.forName(driver).newInstance();
								conn = DriverManager.getConnection(url + dbName, userName, password);

								String query = "select id, post, person_id from post where group_id='" + group_id + "'";
								String query2 = new String();
								String query3 = new String();

								int post_id;
								int id;
								Statement stmt = conn.createStatement();
								ResultSet rs = stmt.executeQuery(query);
								ResultSet rs2;
								ResultSet rs3;
						%> <%
 	//	System.out.println("Now getting the data for posts");
 		while (rs.next()) {

 			//		System.out.println("now getting the posts");
 %>

						<table id="alignment" align="center">
							<tr>
								<td>
									<%
										query3 = "select first_name from person where person_id='" + rs.getInt("person_id") + "'";
												stmt = conn.createStatement();
												rs3 = stmt.executeQuery(query3);
												while (rs3.next()) {
									%><label> <%=rs3.getString("first_name")%>
								</label> <%
 	}
 %> Posted: <%
 	if (session.getAttribute("role") == "User") {
 %><textarea rows="1" cols="50" readonly
										onkeyup="autoSize(this);"> <%=rs.getString("post")%>
					</textarea>
									<button type="button" disabled>Add changed Post</button> <%
 	} else // the user is admin ! 
 			{
 				id = rs.getInt("id");
 				post = rs.getString("post");
 %><textarea id="<%=rs.getInt("id")%>" rows="1" cols="50"
										onkeyup="autoSize(this);" name="updatedpost">  <%=rs.getString("post")%> 
					</textarea>
									<button type="button" onclick="editpost('<%=id%>')">
										Add changed Post</button> <%
 	}
 %>
								</td>
							</tr>


							<%
								query2 = "select comment,person_id from comment where p_id='" + rs.getInt("id") + "'";
										stmt = conn.createStatement();
										rs2 = stmt.executeQuery(query2);

										while (rs2.next()) {
							%>
							<tr>
								<td>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <%
 	query3 = "select first_name from person where person_id='" + rs2.getInt("person_id") + "'";
 				stmt = conn.createStatement();
 				rs3 = stmt.executeQuery(query3);
 				while (rs3.next()) {
 					out.println(rs3.getString("first_name"));
 				}
 %> Commented : <%=rs2.getString("comment")%>

								</td>
							</tr>


							<%
								}
							%>

						</table> <%
 	//System.out.println("Comming on the button click event");
 			id = rs.getInt("id");
 			post = rs.getString("post");
 			//System.out.println("Comming on the button click event: " + post);
 %> <input type="button" name="InsertComment"
						onclick="callinsertservlet(<%=id%>,'<%=post%>')"> Add
						Comment</input>
					</td>
				</tr>

				<%
					}
					}

					catch (SQLException e) {
						e.printStackTrace();
					}
				%>
				<tr>
					<td><br></td>
				</tr>

			</table>
			<textarea name="text"></textarea>
			<button type="submit" name="InsertPost">Add a new post</button>
		</div>
	</form>
</body>
</html>