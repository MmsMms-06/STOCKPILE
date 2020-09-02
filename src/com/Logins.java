package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logins")
public class Logins extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out=response.getWriter();  
		LoginDao dao = new LoginDao();
		if(dao.login(email, password))
		{  System.out.println("inside servlet");
		
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			session.setAttribute("password", password);
			  out.print("Welcome!");  
			response.sendRedirect("main.html");
		}
		else{
			//out.println("<html><h1>Entered email id or password wrong<h1><button onClick=document.location='login.html'>Login</button></html>"); 

			response.sendRedirect("login.html");
			 
			
		}	
	}

}
