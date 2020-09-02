package com;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlterDao {
	public boolean alter(String email, String password){
try{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
     System.out.println("Driver loaded successfully..");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
     System.out.println("Connection established successfully...");
     String sql = "update account set password=? where email=?";
     System.out.println("st executed");
     PreparedStatement st = con.prepareStatement(sql);
     System.out.println("st");
     st.setString(1, email);
     st.setString(2, password);
     int rs = st.executeUpdate();
     System.out.println("st1");
     if(rs>0){
  	   
        return true;
     }
     
}
catch(Exception e)
{
	System.out.println(e);
}
return false;
}
}