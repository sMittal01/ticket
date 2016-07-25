<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.ticket.system.beans.TicketBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Ticket Details</title>
</head>
<body>
	<br>
	<h3 align="center">Welcome to Central Ticketing System</h3>
	<br>

	<h5 align="right">
		Welcome
		<%=request.getSession().getAttribute("UserName")%></h5>
	<h5 align="right">
		<a href="logout.jsp">Logout</a>
	</h5>
	<%
		Object obj = request.getSession().getAttribute("bean");
		if (null != obj) {
			TicketBean bean = null;
			Gson gson = new Gson();
			if (null != obj) {
				bean = gson.fromJson(obj.toString(), TicketBean.class);
			}
			request.getSession().removeAttribute("bean");
			if (null != bean) {
	%>
	<form name="f4" action="ticket" method="post">
		<table align="center">
			<tr>
				<td>Ticket Id</td>
				<td><input type="text" name="id" value='<%=bean.getId()%>'
					disabled="disabled"></td>
				<td><input type="hidden" name="id" id="id"
					value='<%=bean.getId()%>'></td>
			</tr>
			<tr>
				<td>Ticket Status</td>
				<td><input type="text" name="status"
					value='<%=bean.getStatus()%>'></td>
			</tr>
			<tr>
				<td>Ticket Processor</td>
				<td><input type="text" name="processor"
					value='<%=bean.getProcessor()%>'></td>
			</tr>
			<tr>
				<td>Ticket Reporter</td>
				<td><input type="text" name="reporter"
					value='<%=bean.getReporter()%>'></td>
			</tr>
			<tr>
				<td>Ticket Desc.</td>
				<td><input type="text" name="desc"
					value='<%=bean.getDescription()%>'></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Update" type="submit"></td>
			</tr>
		</table>
	</form>
	<%
		}
		} else {
	%>
	<form name="f4" action="ticket" method="post">
		<table align="center">
			<tr>
				<td>Ticket Status</td>
				<td><select name="status" onchange="">
						<option value="new">New</option>
						<option value="in Process">In Process</option>
						<option value="closed">Closed</option>
				</select></td>
			</tr>
			<tr>
				<td>Ticket Processor</td>
				<td><input type="text" name="processor"></td>
			</tr>
			<tr>
				<td>Ticket Reporter</td>
				<td><input type="text" name="reporter"
					value='<%=request.getSession().getAttribute("UserName")%>' disabled>
				</td>
			</tr>
			<tr>
				<td>Ticket Desc.</td>
				<td><input type="text" name="desc"></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create" type="submit"></td>
			</tr>
		</table>
	</form>

	<%
		}
	%>
	<br>
	<br>
	<table align="center">
		<tr>
			<td><a href="ticket.jsp">Home</a></td>
		</tr>
	</table>
</body>
</html>