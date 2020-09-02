package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String password = request.getParameter("password");
		System.out.println(password);
		int choice = Integer.parseInt(request.getParameter("choice"));
		System.out.println(choice);
		FormDao dao = new FormDao();
		if(dao.choice(id, password,choice))
		{  System.out.println("inside servlet");
		
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("password", password);
			session.setAttribute("choice", choice);
			response.sendRedirect("Register.jsp");
			System.out.println("start");
		}
		else{
			  
			response.sendRedirect("userpage.html");
			System.out.println("exit");
			
		}	
	}

}
