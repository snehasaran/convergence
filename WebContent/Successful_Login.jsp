<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    import= "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="successfullogin.css">
</head>
<body>
<form name="Welcome" action="View_Login.jsp" method="post">

	<% 
	String user_name = new String();
	user_name = request.getParameter("user_name");
	%>
<h2> Welcome, <% out.print(user_name); %> </h2>
		
		<table id="alignment" border = "0" align="center">
		
		<tr> <td> </td></tr> 
		<tr> <td><h3>Your groups are:</h3></td>  </tr>
<%
System.out.println("MySQL Connect Example.");
Connection conn = null;
String url = "jdbc:mysql://localhost:3306/";
String dbName = "hw5";
String driver = "com.mysql.jdbc.Driver";
String userName = "root"; 
String password = "mysql";
try
	{
	System.out.println("Test 1");
	Class.forName(driver).newInstance();
	System.out.println("Test 2");
	conn = DriverManager.getConnection(url+dbName,userName,password);
	System.out.println("Test 3");
	
	
	String query= "select group_name, group_id  from groups where group_id in (select group_id from group_person where person_id in(select person_id from person where user_name = '"+ user_name +"'))";
	System.out.println("query to be exexuted is: " + query);
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{

%>
		<tr>
			<td><h3> <a href = "Group_page.jsp?group_id=<%= rs.getInt("group_id")%>&group_name=<%= rs.getString("group_name") %>"> <%=rs.getString("group_name")%> </h3></a> </td>
		</tr>
		<%
	
	System.out.println(rs.getInt("group_id"));
		System.out.println(rs.getString("group_name"));	
	}
	
	System.out.println ("got the pages successfully");
	
}

catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
		
		</table>
		<table align="right">
		<tr>
		<td>
		<a id = "pos" href="View_Login.jsp">LogOut</a>
		</td>
	</tr>
		
		</table>
		
		</form>

</body>
</html>