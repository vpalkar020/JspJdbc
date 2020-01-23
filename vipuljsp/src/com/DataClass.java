package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		String url="jdbc:mysql://localhost:3306/vipul";
		String user="root";
		String password="Vipul@123";
		if("select".equals(request.getParameter("view"))) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection(url,user,password);
			Statement stt=con.createStatement();
			ResultSet rs=stt.executeQuery("select * from student");
			while(rs.next()) {
			out.println("<h1>"+rs.getString("sid")+"</h1>");	
			out.println("<h1>"+rs.getString("sname")+"</h1>");	
			out.println("<h1>"+rs.getString("martks")+"</h1>");	
			}
		}catch(Exception e) {
			response.sendRedirect("error.jsp");
		}
	
	}
		else {
			response.sendRedirect("member.jsp");
		}
	}

}
