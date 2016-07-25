<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.ticket.system.beans.TicketBean"%>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br>
	<h3 align="center">Welcome to Central Ticketing System</h3>
	<br>

	<h5 align="right">
		Welcome
		<%=request.getSession().getAttribute("UserName")%></h5>
	<h5 align="right"><a href="logout.jsp">Logout</a></h5>

	<%
		String gsonString = (String)request.getSession(false).getAttribute("ObjectList");
		String user = (String) request.getSession().getAttribute("UserName");
		Gson gson = new Gson();
		List aList = gson.fromJson(gsonString, List.class);

		if (null != aList && !aList.isEmpty()) {
	%>
	<table align="center">
		<tr>
			<td>Tickets to be Processed</td>
			<td>
				<%
					for (int i = 0; i < aList.size(); i++) {
							Map myMap = (Map) aList.get(i);
							
							if (myMap.get("processor").toString().equalsIgnoreCase(user)) {
								String obj = myMap.get("id").toString();
								String myFinalVal = obj.substring(0, obj.indexOf("."));
								out.println("<a href=login?value="+myMap.get("id")+" name="+myFinalVal+"value="+myFinalVal+">" + myFinalVal + " </a>");

							}

						}
				%>
			</td>
		</tr>

		<tr>
			<td>Tickets Raised</td>
			<td>
				<%
					for (int i = 0; i < aList.size(); i++) {
							Map myMap = (Map) aList.get(i);
							
							if (myMap.get("reporter").toString().equalsIgnoreCase(user)) {
								String obj = myMap.get("id").toString();
								String myFinalVal = obj.substring(0, obj.indexOf("."));
								out.println("<a href=login?value="+myMap.get("id")+" name="+myFinalVal+ "value="+myFinalVal+">" + myFinalVal + " </a>");
							}

						}
				%>
			</td>
		</tr>
	</table>

	<%
		}else{
			%>
				<h3 align="center">No tickets for you</h3>
			<%
		}
	%>
	
	<table align="center">
		<tr><td><a href="ticketdetails.jsp">Create Ticket</a></td></tr>
	</table>
	

</body>
</html>