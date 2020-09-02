package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgotDao {
	public boolean forgot(String email, String countrycode,Long mobilenumber,String security){
        try {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded successfully..");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
            System.out.println("Connection established successfully...");
            String sql = "select * from account where email=? and countrycode=? and mobilenumber=? and security=?";
            System.out.println("Conn");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, countrycode);
            st.setLong(3, mobilenumber);
            st.setString(4, security);
           ResultSet rs = st.executeQuery();
           System.out.println(rs);
           if(rs.next()){
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
