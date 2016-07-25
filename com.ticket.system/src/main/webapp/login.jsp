<%@ page errorPage="error.jsp"%>
<html>
<head>
<link rel="stylesheet" href="css/style.css">


<script type="text/javascript">
	function testForm() {
		var userName = document.f1.username.value;
		if (userName == "" || userName == " ") {
			alert("Username is blank");
			return false;
		}

		var password = document.f1.password.value;

		if (password == "" || password == " ") {
			alert("Password is blank");
			return false;
		}
		return true;
	}
</script>
</head>
<body>

	<br>
	<h3 align="center">Welcome to Central Ticketing System</h3>
	<br>
	<%
		Object message = request.getSession().getAttribute("message");
		if (null != message) {
			
	%>

	<h3 align="center"><%=message.toString() %></h3>
	<% 
		}
		request.getSession().removeAttribute("message");
	%>
	<h4 align="center">Login</h4>
	<br>
	<form name="f1" action="login" method="post"
		onsubmit="return testForm()">
		<table align="center">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Login" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
