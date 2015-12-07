<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*" import="java.util.*"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<style>
.btn-default {
	color: #fff;
	background-color: #080808;
}
</style>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>

	var $ = jQuery;
	
	$(function() {
		$(".like-button").click(function() {
			var postId = $(this).parent().attr("id");
			$.ajax({
				url : 'like',
				data : {
					id : postId
				},
				success : function(responseText) {
					if(responseText === "true") {
						var $likeCountElement = $("#"+postId).find(".like-count");
						var updatedCount = parseInt($likeCountElement.text()) + 1; 						
						$likeCountElement.text(updatedCount); 
					} else {
						$("#" + postId).find(".like-error").fadeIn(2000).fadeOut(2000);
					}
				}
			});
		});

		$(".endorse-button").click(function(){
			var postId = $(this).parent().attr("id");
			var endorsedDivElement = $("#" + postId + " .endorsed-post");

			// make an ajax call if has not been endorsed previously
			if(endorsedDivElement.length == 0) {
				$.ajax({
					url : 'endorse',
					data : {
						id : postId
					},
					success : function(responseText) {
						if(responseText === "true") {
							var divAlert = "<div class='alert alert-success endorsed-post' role='alert' style='margin: 5px 0px 0px 5px;'>This post has been endorsed by Group Admin</div>";
							$("#" + postId).append(divAlert);
						} 
					}
				});
			}
		});
	});

	

	

	function editpost(value)
	{
		var changed_post = document.getElementById(value).value;
		//alert("control comes here !! yeeee" + changed_post);
		document.location.href="updatepost?post_id=" + value +"&post=" + changed_post;
		//alert ("the call was successful");
	}

</script>

</head>
<body style="background-color:#e9eaed">
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

	
	<div class="container-fluid col-md-offset-2 col-md-8" >
		<h2 align="center">
			Welcome to the
			<%=request.getParameter("group_name")%>
			page
		</h2>

		<%
			session.setAttribute("group_id", request.getParameter("group_id"));
			session.setAttribute("group_name", request.getParameter("group_name"));
			String group_id = request.getParameter("group_id");

			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "hw5";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "admin";
			String password = "";
			String post;
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url + dbName, userName, password);

				String query = "select id, post, person_id from post where group_id='" + group_id + "' order by id desc";

				int post_id;
				int id;
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				ResultSet rs2;
				ResultSet rs3;
				
				query = "select * from group_admins where person_id="+session.getAttribute("person_id")+" and group_id="+request.getParameter("group_id")+"";
				
				stmt = conn.createStatement();
				ResultSet checkRoleRS = stmt.executeQuery(query);
				boolean isGroupAdmin = false;
				while(checkRoleRS.next()){
						isGroupAdmin = true;
				} 	
				
		%>

		<form name="Group_page" action="insert" method="post" class="form-horizontal">
			<div class="new-post-block row">
				<div class="col-md-12" style="margin: 5px 0px 5px 0px">
					<textarea rows="3" class="col-md-12 form-control" name="post-text" placeholder="Create new post here"></textarea>
				</div>
				<div class="col-md-12" style="margin: 5px 0px 5px 0px">
					<button type="submit" class="btn btn-primary btn-sm pull-right"
						style="border-radius: 4px; width: 80px; margin-right: 20px" >Post</button>
				</div>
			</div>
		</form>

		<div class="all-posts">
			<% while (rs.next()) {
			%>
			<div class="post-block panel panel-default"
				style="margin: 10px 0px 10px 0px">
			<%
					String getPersonNameQuery = "select first_name from person where person_id='" + rs.getInt("person_id") + "'";
					stmt = conn.createStatement();
					rs3 = stmt.executeQuery(getPersonNameQuery);
					String postPersonName="";
					while (rs3.next()) {
						postPersonName = rs3.getString("first_name");
					}
					String postContent = rs.getString("post");
			
					query = "select * from like_post_person where post_id=?";
					PreparedStatement preparedStatement = conn.prepareStatement(query);
					preparedStatement.setInt(1, rs.getInt("id"));
					ResultSet resultSetLikes = preparedStatement.executeQuery();
					int likeCount = 0;
					
					while(resultSetLikes.next()) {
						likeCount += 1;
					}
							
					query = "select * from post where id=? and endorse=?";
					preparedStatement = conn.prepareStatement(query);
					preparedStatement.setInt(1, rs.getInt("id"));
					preparedStatement.setBoolean(2, true);
					
					ResultSet resultSetEndorse = preparedStatement.executeQuery();
					boolean isEndorsed = false;
					
					while(resultSetEndorse.next()) {
						isEndorsed = resultSetEndorse.getBoolean("endorse");
						
					}

			%>
								
				<div class="post-content">
					<h3 style="margin-left: 15px"><b><%=postPersonName%>: </b><%= postContent %></h3>
				</div>
				<div id=<%=rs.getInt("id") %>>
					<button  type="button" class="btn btn-default btn-sm like-button" style="margin-left: 15px">
						<span class="glyphicon glyphicon-star "></span> Like
					</button>
					<span><b class="like-count"><%=likeCount %></b>  user(s) liked this post </span>
					<% if(isGroupAdmin){%>
						<button type="button" class="btn btn-default btn-sm endorse-button pull-right" style="margin: 0px 20px 0px 0px" >
							<span class="glyphicon glyphicon-menu-up "></span> Endorse
						</button>
					<%} %>
					<% if(isEndorsed){
					%>
						<div class="alert alert-success endorsed-post text-center" role="alert" style="margin: 15px 0px 15px 5px;">This post has been endorsed by Group Admin</div>
					<%} %>
					<div class="alert alert-info like-error text-center" role="alert" style="display: none; margin: 5px 0px 0px 5px;">You already liked this post</div>
				</div>
				<hr />
				<div class="post-comments">
					
			<%
					String getCommentsQuery = "select comment,person_id from comment where p_id='" + rs.getInt("id") + "'";
					stmt = conn.createStatement();
					rs2 = stmt.executeQuery(getCommentsQuery);

					while (rs2.next()) {
						String getPersonFromCommentsTable = "select first_name from person where person_id='" + rs2.getInt("person_id") + "'";
						stmt = conn.createStatement();
						ResultSet rs4 = stmt.executeQuery(getPersonFromCommentsTable);
						String commentText = rs2.getString("comment");
						while (rs4.next()) {
							String commentPersonName = rs4.getString("first_name");
			%>
					<div class="each-comment col-md-12">
							<p class="comment-text">
								<b><%=commentPersonName%>: </b>
								<%=commentText %> 
							</p>
					</div>
			<%
							}
						}
					
					id = rs.getInt("id");
					session.setAttribute("post_id", id);
					post = rs.getString("post");
					System.out.println("Comment is : " + post);
			%>
				</div>
				<form action="comment" method="post" class="form-horizontal">
					<div class="new-comment-text row" style="margin: 5px 0px 5px 0px">
						<div class="col-md-12" style="margin: 5px 0px 5px 0px">
							<textarea rows="2" name="comment-text-area"class="col-md-12 form-control" placeholder="Write a comment here..." style="margin: 0px 0px 5px 0px"></textarea>
						</div>
						<div class="col-md-12" style="margin: 5px 0px 5px 0px">
							<input type="hidden" name="post-id" value=<%=id%> />
							<button type="submit" class="btn btn-default btn-sm pull-right"
								style="border-radius: 4px">Add Comment</button>
						</div>
					</div>
				</form>
			</div>	
			<%	
					}
			%>
			</div>
			<% 
			}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
			%>						
		</div>
</body>
</html>