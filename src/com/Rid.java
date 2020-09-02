package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Rid")
public class Rid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id = Integer.parseInt(request.getParameter("id"));
		     String password = request.getParameter("password");
		     HttpSession session = request.getSession();
		     session.setAttribute("id", id);
				session.setAttribute("password", password);
				response.sendRedirect("FormChoice.html");
	}
		catch(Exception e){
		System.out.println(e);	
		}

	}

}
