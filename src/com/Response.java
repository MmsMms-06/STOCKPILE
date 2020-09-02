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

@WebServlet("/Response")
public class Response extends HttpServlet {
	int id;
	String email;
	String answer1;
	String answer2;
	String answer3;
	String answer4;
	String answer5;
	
	



	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getAnswer1() {
		return answer1;
	}





	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}





	public String getAnswer2() {
		return answer2;
	}





	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}





	public String getAnswer3() {
		return answer3;
	}





	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}





	public String getAnswer4() {
		return answer4;
	}





	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}





	public String getAnswer5() {
		return answer5;
	}





	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession(false);
		String email = (String) session.getAttribute("email");
		int id = (int)session.getAttribute("id");
			System.out.println(email);
			System.out.println(id);
			String answer1 = request.getParameter("answer1");
			String answer2 = request.getParameter("answer2");
			String answer3 = request.getParameter("answer3");
			String answer4 = request.getParameter("answer4");
			String answer5 = request.getParameter("answer5");
			setId(id);
			System.out.println(id);
			setEmail(email);
			System.out.println(email);
			setAnswer1(answer1);
	        setAnswer2(answer2);
	        setAnswer3(answer3);
	        setAnswer4(answer4);
	        setAnswer5(answer5);
	        
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        System.out.println("Driver loaded successfully..");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
	        System.out.println("Connection established successfully...");
	        String sql = "insert into response values(?,?,?,?,?,?,?)";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setInt(1,id);
	        System.out.println(id);
	        st.setString(2, email);
	        System.out.println(email);
	        st.setString(3, answer1);
	        System.out.println(answer1);
	        st.setString(4, answer2);
	        System.out.println(answer2);
	        st.setString(5, answer3);
	        st.setString(6, answer4);
	        st.setString(7, answer5);
	        int rs = st.executeUpdate();
	        if(rs>0){
	     	   con.commit();
	            response.sendRedirect("response.html");
	        }
	        else{
	     	   response.sendRedirect("user.html");
	        } 

	   
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
