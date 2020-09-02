package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Validation")
public class Validation extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		UserpageDao dao = new UserpageDao();
		if(dao.user(id, password))
		{  System.out.println("inside servlet");
		
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("password", password);  
			response.sendRedirect("response.jsp");
			System.out.println("start");
		}
		else{
			  
			response.sendRedirect("userpage.html");
			System.out.println("exit");
			
		}	
	}
}
