<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,model.Todo"%>
<%@page import="java.util.*,model.Subscription"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="TodoServlet">
		Title: <br> <input type="text" name="title" /><br>
		Description : <br>
		<textarea name="description"></textarea>
		<br> <input type="submit" value="Add" />
	</form>

	<hr>
	<h4>To-does List (user)</h4>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Todo> todos = (List<Todo>) request.getAttribute("todos");
			for (Todo todo : todos) {
		%>
		<li><a href="TodoServlet?id=<%=todo.getId()%>"><%=todo.getTitle()%></a></li>
		<%
			}
		%>
	</ol>
	<hr>
	<h4>To-does List (<a href="GroupServlet">groups</a>)</h4>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Todo> availables = (List<Todo>) request.getAttribute("availables");
			for (Todo available : availables) {
		%>
		<li><a href="TodoServlet?id=<%=available.getId()%>"><%=available.getTitle()%></a></li>
		<%
			}
		%>
	</ol>

</body>
</html>