package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VipulJsp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		private int hitcount;
		public void init() {
			hitcount=0;
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			HttpSession session=request.getSession();
		if("SignIn".equals(request.getParameter("SignInName"))) {
			String unamesignin=request.getParameter("unamesignin");
			String passsignin=request.getParameter("passsignin");
			if(CandidateDao.validate(unamesignin, passsignin))
			{
				
				
				session.setAttribute("username",unamesignin);
				out.println(hitcount);
				response.sendRedirect("member.jsp");
			}
			else
			{
					hitcount++;
					out.println("<html>");
					out.println("<head>");
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('User or password incorrect And 3 Login Attempts:');");
				   out.println("location='login.jsp';");
				   out.println("</script>");
				   out.println("</head>");
				   out.println("<body>");
				   out.println("</body>");
				   out.println("</html>");
				   //response.sendRedirect("login.jsp");
			}
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
			
		try {
			
			if("SignUp".equals(request.getParameter("SignUpName"))) {	
			String uname=request.getParameter("unamesignup").toString();
			String pass=request.getParameter("passsignup").toString();
			int mob=Integer.parseInt(request.getParameter("mob"));
			Candidate c=new Candidate();
			c.setUsername(uname);
			c.setMobile(mob);
			c.setPasskey(pass);
			int status=CandidateDao.save(c);
			if(status>0) {
				out.println("SignUp successfully");
				response.sendRedirect("login.jsp");
			}
			else out.println("SignUp Error");
            
			}
		}
			catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
			
		}
		
		}
		
	}