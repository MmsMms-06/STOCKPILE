package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String countrycode= request.getParameter("countrycode");
		Long mobilenumber = Long.parseLong(request.getParameter("mobilenumber"));
		String security= request.getParameter("security");
		ForgotDao dao = new ForgotDao();
		if(dao.forgot(email, countrycode, mobilenumber,security))
		{  System.out.println("inside servlet");
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			session.setAttribute("countrycode",countrycode);
			session.setAttribute("mobilenumber", mobilenumber);
			response.sendRedirect("alter.html");
		}
		else{
			response.sendRedirect("forgot.html");
			
		}	
	}

}
