package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Submit")
public class Mysurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("sid"));
		int id = Integer.parseInt(request.getParameter("sid"));
		if(id>0){
		System.out.println(id);
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
		response.sendRedirect("display1.jsp");
	}
		else{
			response.sendRedirect("mysurveys.html");
		}
		}

}
