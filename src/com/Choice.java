package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Choice")
public class Choice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession(false); 
			 int id =(int)session.getAttribute("id");
		        String password =(String)session.getAttribute("password");
		        System.out.println(id);
		        System.out.println(password);
		        int choice = Integer.parseInt(request.getParameter("choice"));
		        System.out.println(choice);
		  
		        
if(id>0){
	
	
	 Class.forName("oracle.jdbc.driver.OracleDriver");
     System.out.println("Driver loaded successfully..");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
     System.out.println("Connection established successfully...");
     String sq = "insert into registerid values(?,?,?)";
     PreparedStatement s = con.prepareStatement(sq);
     s.setInt(1,id);
     s.setString(2, password);
     s.setInt(3, choice);
     int r = s.executeUpdate();
     System.out.println(r);
     if(r>0){
  	   con.commit();
  	   System.out.println("values inserted successfully");
     }
     else{
     	response.sendRedirect("RegisterFormid.html");
     } 
     Class.forName("oracle.jdbc.driver.OracleDriver");
     System.out.println("Driver loaded successfully..");
     Connection co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
     System.out.println("Connection established successfully...");
     System.out.println(choice);
if(choice<2){
		        	 String sql = "insert into registera values(?,?,?,?,?,?,?)";
		        	 PreparedStatement st = co.prepareStatement(sql);
		        	 st.setInt(1, id);
		 	        st.setString(2, "Name");
		 	        st.setString(3, "Surname");
		 	        st.setString(4, "Email");
		 	        st.setString(5, "Gender");
		 	        st.setString(6, "Address");
		 	       st.setString(7, "MobileNumber");

			        int rs = st.executeUpdate();
			        if(rs>0){
			     	   con.commit();
			            response.sendRedirect("completesurvey.html");
			        }
			        else{
			     	   response.sendRedirect("FormChoice.html");
			        } 
				}
		        else if(choice>1){
		        	
		        	 Class.forName("oracle.jdbc.driver.OracleDriver");
		 	        System.out.println("Driver loaded successfully..");
		 	        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
		 	        System.out.println("Connection established successfully...");
		        	String sql = "insert into registerb values(?,?,?,?,?,?,?,?,?,?,?)";
		        	 PreparedStatement st = conn.prepareStatement(sql);
		        	 st.setInt(1, id);
		 	        st.setString(2, "Name");
		 	        st.setString(3, "Surname");
		 	        st.setString(4, "Email");
		 	        st.setString(5, "DateofBirth");
		 	        st.setString(6, "Gender");
		 	       st.setString(7, "Caste");
		 	      st.setString(8, "Religion");
		 	        st.setString(9, "Nation");
		 	        st.setString(10, "Address");
		 	       st.setString(11, "MobileNumber");
		 	      int rs = st.executeUpdate();
			        if(rs>0){
			     	   con.commit();
			            response.sendRedirect("completesurvey.html");
			        }
			        }
			        else{
			     	   response.sendRedirect("FormChoice.html");
			        } 
		        }

		        
				else{
					response.sendRedirect("RegisterFormid.html");
				System.out.println("wrong");
				}
		        }
		
	catch(Exception e){
		System.out.println(e);
	}
	}
}
