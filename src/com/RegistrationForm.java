package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Accept")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ssid"));
		int id = Integer.parseInt(request.getParameter("ssid"));
		int choice = Integer.parseInt(request.getParameter("choice"));
		if(id>0){
		System.out.println(id);
		System.out.println(choice);
		if(choice<2){
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
		session.setAttribute("choice", choice);
		response.sendRedirect("Registera.jsp");
		System.out.println("a");
		}
		else if(choice>1){
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			session.setAttribute("choice", choice);
			response.sendRedirect("Registerb.jsp");
			System.out.println("b");
		}
	}

	}
}


