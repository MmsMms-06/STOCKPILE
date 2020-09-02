package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Signups")
public class Signups extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String dateofbirth = request.getParameter("dateofbirth");
        String countrycode = request.getParameter("countrycode");
        Long mobilenumber = Long.parseLong(request.getParameter("mobilenumber"));
        String security = request.getParameter("security");
        
        Signupgs c=new Signupgs();
        c.setUsername(username);
        c.setEmail(email);
        c.setPassword(password);
        c.setGender(gender);
        c.setDateofbirth(dateofbirth);
        c.setCountrycode(countrycode);
        c.setMobilenumber(mobilenumber);
        c.setSecurity(security);
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded successfully..");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
        System.out.println("Connection established successfully...");
        String sql = "insert into account values(?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, email);
        st.setString(3, password);
        st.setString(4, gender);
        st.setString(5, dateofbirth);
        st.setString(6, countrycode);
        st.setLong(7, mobilenumber);
        st.setString(8, security);
        PrintWriter pw=response.getWriter();
       int rs = st.executeUpdate();
       if(rs>0){
    	   con.commit();
           pw.println("datasaved successfully");
           response.sendRedirect("created.html");
       }
       else{
    	   response.sendRedirect("signup.html");
       } 

  

     
	}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
