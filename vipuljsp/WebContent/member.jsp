<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
			
		}
		else{
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>"+session.getAttribute("username")+"</h1>");
			out.println("</body>");
			out.println("</html>");
		}
%>


hey welcome ${username}
<form action="data">
<table border="1">
<tr>
<td><input type="text" name="view"></td>
<td><input type="submit" name="select"></td>
</tr>
</table>
</form>
<form action="Logoutpage">
<input type="submit" value="logout">
</form>
</body>
</html>