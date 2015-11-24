<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
var checkbox;

for (var i=0; i<5; i++)
{
	checkbox = "<input type='checkbox' value = '" +i+ "' name  = 'mycheckedbox'/>"
	if (i == 2)
	{
		checkbox = "<input type='checkbox' value = '" +i+ "' name  = 'mycheckedbox' checked = '" + true + "'/>"
	}
	document.write(checkbox +" A " + i + " <br/>")
}


function getCheckedBoxes(chkboxName) {
	 av = document.getElementsByName("mycheckedbox");
	 for (var e=0;e<5;e++) {
	  if (av[e].checked==true) 
		  alert(e + " selected");
	  }
}

getCheckedBoxes("mycheckedbox");
</script>
<body>

	<form name="SignUp" action="SignUp" method="post">

		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="txtUsrName" id="txtUsrName"></input></td>
				<td>* make sure the id is unique</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="txtFirstName" id="txtFirstName"></input>
				</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="txtLastName" id="txtLastName"></input>
				</td>
			</tr>

			<tr>
				<td>City:</td>
				<td><input type="text" name="txtCity" id="txtCity"></input></td>
			</tr>

			<tr>
				<td>State:</td>
				<td><input type="text" name="txtState" id="txtState"></input></td>
			</tr>

			<tr>
				<td>Age:</td>
				<td><input type="text" name="txtAge" id="txtAge"></input></td>
			</tr>

			<tr>
				<td>Phone Type:</td>
				<td><select name="phone_type">
						<option value="1">Mobile</option>
						<option value="2">Home</option>
						<option value="3">Work</option>
				</select></td>
			</tr>


			<tr>
				<td>Phone Number:</td>
				<td><input type="text" name="txtPhoneNo" id="txtPhoneNo"></input></td>
			</tr>

			<tr>
				<td>Email id:</td>
				<td><input type="text" name="txteMail" id="txteMail"></input></td>
			</tr>


			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="rdGender" value="male" /> Male<br />
				<td><input type="radio" name="rdGender" value="female" />
					Female<br /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="subAddUser" id="subSubmit"
					value="Add User"></input></td>
			</tr>
			<% for(int i = 0; i < 10; i+=1) { %>
			<tr>
				<td><input type="checkbox" name="<%= i %>"> <%= i %> </input></td>
			</tr>
			<% } %>

		</table>
	</form>
</body>
</head>
</html>
