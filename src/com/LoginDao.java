package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginDao {
		public boolean login(String email, String password){
	                try {
	                	
	                    Class.forName("oracle.jdbc.driver.OracleDriver");
	                    System.out.println("Driver loaded successfully..");
	                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
	                    System.out.println("Connection established successfully...");
	                    String sql = "select * from account where email=? and password=?";
	                    PreparedStatement st = con.prepareStatement(sql);
	                    st.setString(1, email);
	                    st.setString(2, password);
	                   ResultSet rs = st.executeQuery();
	                   if(rs.next()){
	                	   System.out.println(rs.getString(1)+"  "+rs.getString(2));
	                	   return true;
	                   }
	                   
	   
	                } catch (ClassNotFoundException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
					return false;
			
	        }
	}