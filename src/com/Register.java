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
@WebServlet("/Registers")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session=request.getSession(false);
			String mail = (String) session.getAttribute("email");
			int id = (int)session.getAttribute("id");
			int choice = (int)session.getAttribute("choice");
				System.out.println(mail);
				System.out.println(id);
				System.out.println(choice);
				if(choice<2){
					String name = request.getParameter("name");
					String surname = request.getParameter("surname");
					String email = request.getParameter("email");
					String gender = request.getParameter("gender");
					String address = request.getParameter("address");
					String mobilenumber = request.getParameter("mobilenumber");
					RegisterCg c = new RegisterCg();
					c.setId(id);
					System.out.println(id);
					c.setMail(email);
					System.out.println(email);
					c.setName(name);
			        c.setSurname(surname);
			        c.setEmail(email);
			        c.setGender(gender);
			        c.setAddress(address);
			        c.setMobilenumber(mobilenumber);
			        
			        Class.forName("oracle.jdbc.driver.OracleDriver");
			        System.out.println("Driver loaded successfully..");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
			        System.out.println("Connection established successfully...");
			        String sql = "insert into forma values(?,?,?,?,?,?,?,?)";
			        PreparedStatement st = con.prepareStatement(sql);
			        st.setInt(1,id);
			        System.out.println(id);
			        st.setString(2, mail);
			        System.out.println(email);
			        st.setString(3, name);
			        st.setString(4, surname);
			        st.setString(5, email);
			        st.setString(6, gender);
			        st.setString(7, address);
			        st.setString(8, mobilenumber);
			        int rs = st.executeUpdate();
			        if(rs>0){
			     	   con.commit();
			            response.sendRedirect("response.html");
			        }
			        else{
			     	   response.sendRedirect("user.html");
			        } 
			        }
				else if(choice>1){
					String name = request.getParameter("name");
					String surname = request.getParameter("surname");
					String email = request.getParameter("email");
					String dateofbirth=request.getParameter("dateofbirth");
					String gender = request.getParameter("gender");
					String caste = request.getParameter("caste");
					String religion = request.getParameter("religion");
					String nation = request.getParameter("nation");
					String address = request.getParameter("address");
					String mobilenumber = request.getParameter("mobilenumber");
					RegisterCg c = new RegisterCg();
					c.setId(id);
					System.out.println(id);
					c.setMail(email);
					System.out.println(email);
					c.setName(name);
			        c.setSurname(surname);
			        c.setEmail(email);
			        c.setDateofBirth(dateofbirth);
			        c.setGender(gender);
			        c.setCaste(caste);
			        c.setReligion(religion);
			        c.setNation(nation);
			        c.setAddress(address);
			        c.setMobilenumber(mobilenumber);
			        
			        Class.forName("oracle.jdbc.driver.OracleDriver");
			        System.out.println("Driver loaded successfully..");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
			        System.out.println("Connection established successfully...");
			        String sql = "insert into formb values(?,?,?,?,?,?,?,?,?,?,?,?)";
			        PreparedStatement st = con.prepareStatement(sql);
			        st.setInt(1,id);
			        System.out.println(id);
			        st.setString(2, mail);
			        System.out.println(email);
			        st.setString(3, name);
			        st.setString(4, surname);
			        st.setString(5, email);
			        st.setString(6, dateofbirth);
			        st.setString(7, gender);
			        st.setString(8, caste);
			        st.setString(9, religion);
			        st.setString(10, nation);
			        st.setString(11, address);
			        st.setString(12, mobilenumber);
			        int rs = st.executeUpdate();
			        if(rs>0){
			     	   con.commit();
			            response.sendRedirect("response.html");
			        }
			        else{
			     	   response.sendRedirect("user.html");
			        } 	
					
				}
		}
				
	catch(Exception e){
		System.out.println(e);
	}
	}
	

}
