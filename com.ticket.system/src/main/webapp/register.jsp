<%@ page errorPage="error.jsp"%>
<html>
<head>
<link rel="stylesheet" href="css/style.css">


<script type="text/javascript">
	function testForm() {
		var userName = document.f1.username.value;
		if(userName == "" || userName == " "){
			alert("Username is blank");
			return false;
		}
		
		var password = document.f1.password.value;
		
		if(password == "" || password == " "){
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
	<h4 align="center">Register</h4>
	<br>
	<form name= "f1" action="register" method="post" onsubmit="return testForm()">
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
				<td></td><td><input value="Register" type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
