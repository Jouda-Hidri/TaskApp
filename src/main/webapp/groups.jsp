<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,model.Group"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="GroupServlet">
		Title: <br> <input type="text" name="title" /><br>
		Description : <br>
		<textarea name="description"></textarea>
		<br> <input type="submit" value="Add" />
	</form>

	<hr>
	<h4>Groups</h4>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Group> groups = (List<Group>) request.getAttribute("groups");
			for (Group group : groups) {
		%>
		<li><%=group%></li>
		<%
			}
		%>
	</ol>
	<hr>
</body>
</html>