<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,ticket.Ticket"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="GuestServlet">
		Name: <br> <input type="text" name="name" /><br>
		Description : <br>
		<textarea name="description"></textarea>
		<br> <input type="submit" value="Add" />
	</form>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
			for (Ticket ticket : tickets) {
		%>
		<li><%=ticket%></li>
		<%
			}
		%>
	</ol>
	<hr>

	<iframe src="http://www.objectdb.com/pw.html?web-download"
		frameborder="0" scrolling="no" width="100%" height="30"></iframe>
</body>
</html>