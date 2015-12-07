<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet"
	href="https://bootswatch.com/cosmo/bootstrap.min.css">
<link rel="stylesheet" href="successfullogin.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js">
	
</script>
</head>
<body>
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
					<li><a href="View_Login.jsp">Logout </a></li>
				</ul>
			</div>
		</div>
	</nav>

		<div class="container-fluid ">

			<%
				String user_name = new String();
				user_name = request.getParameter("user_name");
				System.out.println("MySQL Conn/LoginServletect Example.");
				Connection conn = null;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "hw5";
				String driver = "com.mysql.jdbc.Driver";
				String userName = "admin";
				String password = "";
				System.out.println("From succesful login " + session.getAttribute("role"));
				try {
					System.out.println("Test 1");
					Class.forName(driver).newInstance();
					System.out.println("Test 2");
					conn = DriverManager.getConnection(url + dbName, userName, password);
					System.out.println("Test 3");
					System.out.println("got the pages successfully");
					String query = "select person_id from person where user_name = '" + user_name + "'";
					System.out.println("query to be executed is: " + query);					
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					int personId =0;
					while(rs.next()) {
						personId = rs.getInt("person_id");
					}
					session.setAttribute("person_id", personId);
					
			%>
			<h2 align="center">
				Welcome
				<%out.print(user_name);%>
			</h2>
			<!-- Sneha changes start here -->


			<!-- new changes -->
			<div class="container">
				<div id = "tabs">
					<ul>
					    <li><a href="#tabs-1">My groups</a></li>
					    <li><a href="#tabs-2">Groups</a></li>
					</ul>
					<div id = "tabs-1" class="list-my-groups">
						<%	
	 						query = "select group_name, group_id, group_descr  from groups where activated_flag = true and group_id in (select group_id from group_person where person_id in(select person_id from person where user_name = '"
	 								+ user_name + "'))";
							//query = "select * from groups";
							System.out.println("query to be executed is: " + query);
							stmt = conn.createStatement();
							rs = stmt.executeQuery(query);
							HashSet<Integer> myGroupIds = new HashSet<Integer>();
							while (rs.next()) {
								myGroupIds.add(rs.getInt("group_id"));
						%>
						
						<div class="row">
							<div class="col-md-12 panel panel-default group-content">
								<div class="panel-body">			
									<div>
										<label for="group-name"><b>Group Name: </b></label> <a
											class="group-title"
											href="Group_page.jsp?group_id=
											 <%=rs.getInt("group_id")%>
											&group_name=
											<%=rs.getString("group_name")%>">
											<%=rs.getString("group_name")%>
										</a>
									</div>
									<div>
										<label for="descr"><b>Description: </b></label> 
										<span class="group-desc"> <%=rs.getString("group_descr")%>
										</span>
										<br />
										<form name=<%=rs.getString("group_name")%> action="subscribe" method="post">						
											<input type="hidden" name="groupId" class="groupId" value=<%=rs.getInt("group_id")%> />
											<input type="hidden" name="subscribe" class="subscribe" value="false" />
											<input type="submit" class="subscribe btn btn-small btn-primary pull-right" value= "Unsubscribe" />
										</form>		
										
									</div>
								
								</div>
							</div>
						</div>
	
						<%
								//System.out.println(rs.getInt("group_id"));
								//System.out.println(rs.getString("group_name"));
							}									
						%>
	
					</div>
					
					<div id = "tabs-2" class="list-groups">
						<%	
							query = "select * from groups where activated_flag = true";
							System.out.println("query to be executed is: " + query);
							stmt = conn.createStatement();
							rs = stmt.executeQuery(query);
							boolean isSubscribed = true;
							while (rs.next()) {
								isSubscribed = myGroupIds.contains(rs.getInt("group_id"));
						%>
						
						<div class="row">
							<div class="col-md-12 panel panel-default group-content">
								<div class="panel-body">
								
									<div>
										<label for="group-name"><b>Group Name: </b></label> 
											<%=rs.getString("group_name")%>
									</div>
									<div>
										<label for="descr"><b>Description: </b></label> 
										<span class="group-desc"> <%=rs.getString("group_descr")%>
										</span>
										<br />
										<form name=<%=rs.getString("group_name")%> action="subscribe" class="grp-subscribe" method="post">
											<input type="hidden" name="groupId" class="groupId" value=<%=rs.getInt("group_id")%> />
											<input type="hidden" name="subscribe" class="subscribe" value=<%=!isSubscribed %> />
											<input type="submit" class="btn-subscribe btn btn-small btn-primary pull-right" value= "Subscribe" />
										</form>		
										
									</div>
								
								</div>
							</div>
						</div>
	
						<%
								System.out.println(rs.getInt("group_id"));
								System.out.println(rs.getString("group_name"));
							}
						}
						catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
									
						%>
	
					</div>					
				</div>		
			</div>
			<!-- new changes end -->	
		</div>
</body>
<script type="text/javascript"> 

var $ = jQuery;
/* $('form input:submit').bind('click', function(event){

	$(event.target).attr('disabled', true);	
}); */
$(function() {
	
    $( "#tabs" ).tabs();
	var subscribeFields = $(".grp-subscribe .subscribe");
	var fieldValue, i;
	for(i = 0; i < subscribeFields.length; ++i) {
		fieldValue = $(subscribeFields[i]).val();
		if(fieldValue === "false") 
			$(subscribeFields[i]).next('input').prop('disabled', true);
	};
  });

</script>

</html>

