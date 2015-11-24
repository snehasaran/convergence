<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*" import = "java.util.*" import = "controller.LoginServlet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Home Page</title>

<script type="text/javascript">

function getCheckedBoxes(chkboxName) 
{
	 av = document.getElementsByName("mycheckedbox");
	 for (var e=0;e<100;e++) 
	 {
	  if (av[e].checked==true)
		  alert(e + " selected");
	}
}



</script>
</head>
<body>
<form name="Admin_Home" action="LoginServlet" method="get">
<% 
	String user_name = new String();
	user_name = request.getParameter("user_name");
	%>
<h2 align = "center">Welcome Admin, <% out.println(user_name); %></h2>
<% System.out.println("The control comes to table tab"); %>
<table id="alignment" border = "0" align = "center">
<% System.out.println("The table tab created"); %>
<%
int i;
Integer j = 0;
Integer count =0;
System.out.println("Now fetching the count " );
count = (Integer)request.getAttribute("count");
System.out.println("The count here is: " + count);
String[] first_name = new String[1000];
String[] group_name = new String[1000];
Integer[] group_id = new Integer[1000];
Integer[] person_id = new Integer[1000];
int counter=0;

String[] first_name_data = new String[1000];
String[] group_name_data = new String[1000];
Integer[] group_id_data = new Integer[1000];
Integer[] person_id_data = new Integer[1000];


System.out.println("Now fetching the data !! ");
first_name = (String[])request.getAttribute("first_name");
System.out.println("First name  is: " + first_name);
group_name = (String[])request.getAttribute("group_name");
group_id = (Integer[])request.getAttribute("group_id");
person_id = (Integer[])request.getAttribute("person_id");
if (first_name != null)
{
System.out.println("the from first_name is : " + first_name.length);
for (int k=0; k<first_name.length;k++)
{
	if((first_name[k] != null && !first_name[k].isEmpty()) &&  
			(group_name[k] != null && !group_name[k].isEmpty()) && 
			(group_id [k] != null) && (person_id[k] != null))
	{
	System.out.println("data fetched first_name: " + first_name[k]);
	first_name_data[counter] = first_name[k];
	System.out.println("group name is:" + group_name[k]);
	group_name_data[counter] = group_name[k];	
	System.out.println("group_id: " + group_id[k]);
	group_id_data[counter] = group_id[k];
	System.out.println("person_id: " + person_id[k]);
	person_id_data[counter] = person_id[k];
	counter++;
	}
}

System.out.println("the length of the data field is: " + counter);

if(counter!= 0 )
{
for (int k=0; k<counter; k++)
{

%>
<tr>
<td> 
<% 
System.out.println("first name is: " + first_name[k]);
System.out.println("group name is: " + group_name[k]);
out.println(first_name_data[k] + " requests approval for " + group_name[k]);
%> 
<a href ="ApproveServlet?person_id=<%=person_id_data[k]%>&group_id=<%=group_id_data[k]%>&user_name=<%=user_name%>"> Approve
</a> &nbsp; <a href ="RejectServlet?person_id=<%=person_id_data[k]%>&group_id=<%=group_id_data[k]%>&user_name=<%=user_name%>"> Reject </a>
</td>
</tr>
<%
}
}
}
%>


<tr>
<td>
<input type="button" name="subGetChked" align = "middle" id="subGetChked" value = "Get Checked Checkboxes" onclick="return getCheckedBoxes(Admin_Home.mycheckedbox);">
<input type="submit" name="subAdd" align = "middle" id="subAdd" value = "Add">
<input type="button" name="subReject" align = "middle" id="subReject" value = "Reject">
</td>
</tr>
</table>
</form>
</body>
</html>