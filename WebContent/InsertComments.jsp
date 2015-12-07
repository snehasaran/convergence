<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments</title>
<link rel="stylesheet" type="text/css" href="insertcomments.css">
</head>
<body>
<h3>The post is  : <%= request.getParameter("post") %>

<% session.setAttribute("post_id", request.getParameter("post_id"));%></h3>

<form name="Insert_comment_page" action="comment" method="post">
<table id = "alignment" align = "center">
<tr>
<td align="center">
<textarea name="comment" rows = "1" cols = "50"> </textarea>
</td>
</tr>
</table>
<input type="submit" name= "InsertComment" value = "Add comment">
</form>
</body>
</html>