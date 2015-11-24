<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*" import = "java.util.*" import = "controller.LoginServlet"
    import = "model.AdminHome"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Home Page</title>
<style>
body
{
margin: 0px;
padding: 0px;
background-image: url('light-violet.jpg');
font-family: 'Source Sans Pro', sans-serif;
font-size: 12pt;
font-weight: 300;
color: white;
}
h2
{
color: white;
text-align: center;
font-family: 'Source Sans Pro', sans-serif;
text-shadow: 5px 5px 5px #FFFF00;
}
#alignment
{
  margin-top:10%;
}
#pos
{
position: absolute;
top:0%;
right:3%;
color: white;
}
a
{
color: white;
}
</style>
</head>
<body>
<form name="Admin_Home" action="LoginServlet" method="get">
<% 
	String user_name = new String();
	user_name = request.getParameter("user_name");
	%>
<h2 align = "center">Welcome Admin, <% out.println(user_name); %></h2>

<table id="alignment" border = "0" align = "center">
<%
Integer i = 0;
Integer j = 0;
Integer count = 0;
count = (Integer)request.getAttribute("count");
String[] first_name = (String[])request.getAttribute("first_name");
String[] group_name = (String[])request.getAttribute("group_name");
first_name = (String[])request.getAttribute("first_name");
group_name = (String[])request.getAttribute("group_name");
for (i=0; i<count; i++)
{
%>
<tr>
<td><input type = 'checkbox' id = '<%= j %>' name = 'requests' value = '<%= j %>'><% out.println(first_name[i] + " requests approval for " + group_name[i]); %></td>

</tr>
<%
j++;
}

System.out.println("value of i = " + i);

%>

<tr>
<td>
<input type="submit" name="subAdd" align = "middle" id="subAdd" value = "Add">
<input type="submit" name="subReject" align = "middle" id="subReject" value = "Reject">
</td>
</tr>
<tr>
		<td>
		<a id = "pos" href="View_Login.jsp">LogOut</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>