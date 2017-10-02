<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,guest.Guest"%>
<%@page import="java.util.*,guest.Membership"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>JPA Guestbook Web Application Tutorial</title>
</head>

<body>
	<form method="POST" action="GuestServlet">
		Name: <br> <input type="text" name="name" /><br>
		Description : <br>
		<textarea name="description"></textarea>
		<br> <input type="submit" value="Add" /> <br> <a
			href="TicketServlet">update</a>
	</form>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Guest> guests = (List<Guest>) request.getAttribute("guests");
			for (Guest guest : guests) {
		%>
		<li><%=guest%></li>
		<%
			}
		%>
	</ol>
	<hr>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Membership> memberships = (List<Membership>) request.getAttribute("memberships");
			for (Membership membership : memberships) {
		%>
		<li><%=membership%></li>
		<%
			}
		%>
	</ol>
	<hr>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Guest> others = (List<Guest>) request.getAttribute("others");
			for (Guest other : others) {
		%>
		<li><%=other%></li>
		<%
			}
		%>
	</ol>
	<hr>

	<iframe src="http://www.objectdb.com/pw.html?web-download"
		frameborder="0" scrolling="no" width="100%" height="30"></iframe>
</body>
</html>