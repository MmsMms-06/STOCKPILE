package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Alter")
public class Alter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	String password = request.getParameter("password");
	HttpSession session=request.getSession(false);  
      String email =(String)session.getAttribute("email");
     System.out.println(email);
     Cgs evo=new Cgs();
     evo.setEmail(email);
     evo.setPassword(password);
     
     Class.forName("oracle.jdbc.driver.OracleDriver");
     System.out.println("Driver loaded successfully..");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
     System.out.println("Connection established successfully...");
     String sql = "update account set password=? where email=?";
     System.out.println("st executed");
     PreparedStatement st = con.prepareStatement(sql);
     System.out.println("email="+evo.getEmail());
     st.setString(1,evo.getPassword());
     System.out.println("st");
     System.out.println("password="+evo.getPassword());
     st.setString(2,evo.getEmail());
     System.out.println("st");
     PrintWriter pw=response.getWriter();
     int rs = st.executeUpdate();
     System.out.println(rs);
     if(rs>0){
  	   con.commit();
         pw.println("datasaved successfully");
         response.sendRedirect("update.html");
     }
     else{
  	   response.sendRedirect("alter.html");
     } 
     
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}
