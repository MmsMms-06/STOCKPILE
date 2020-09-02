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

@WebServlet("/Question")
public class Question extends HttpServlet {
	
	String q1;
	String q2;
	String q3;
	String q4;
	String q5;
	
	
	public String getQ1() {
		return q1;
	}
	public void setQ1(String q1) {
		this.q1 = q1;
	}
	public String getQ2() {
		return q2;
	}
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	public String getQ3() {
		return q3;
	}
	public void setQ3(String q3) {
		this.q3 = q3;
	}
	public String getQ4() {
		return q4;
	}
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	public String getQ5() {
		return q5;
	}
	public void setQ5(String q5) {
		this.q5 = q5;
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession(false); 
			 int id =(int)session.getAttribute("id");
		        String password =(String)session.getAttribute("password");
		        System.out.println(id);
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		String q3 = request.getParameter("q3");
		String q4 = request.getParameter("q4");
		String q5 = request.getParameter("q5");
		if(id>0){
		
		setQ1(q1);
		setQ2(q2);
		setQ3(q3);
		setQ4(q4);
		setQ5(q5);
		
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	        System.out.println("Driver loaded successfully..");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
	        System.out.println("Connection established successfully...");
	        String sq = "insert into surveyid values(?,?)";
	        PreparedStatement s = con.prepareStatement(sq);
	        s.setInt(1,id);
	        s.setString(2, password);
	        int r = s.executeUpdate();
	        if(r>0){
	     	   con.commit();
	        }
	        else{
	        	response.sendRedirect("question.html");
	        } 
	     	   
		
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	        System.out.println("Driver loaded successfully..");
	        Connection co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
	        System.out.println("Connection established successfully...");
	        String sql = "insert into question values(?,?,?,?,?,?)";
	        
	        PreparedStatement st = co.prepareStatement(sql);
	        
	        st.setInt(1, id);
	        st.setString(2, q1);
	        st.setString(3, q2);
	        st.setString(4, q3);
	        st.setString(5, q4);
	        st.setString(6, q5);
	        
	        int rs = st.executeUpdate();
	        if(rs>0){
	     	   co.commit();
	            response.sendRedirect("completesurvey.html");
	        }
	        else{
	     	   response.sendRedirect("question.html");
	        } 
		}
		else{
			response.sendRedirect("id.html");
		System.out.println("wrong");
		}
		}    
		catch(Exception e){
		System.out.println(e);	
		}
	}
}
