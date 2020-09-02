package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormDao {
	public boolean choice(int id, String password , int choice){
        try {
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded successfully..");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
            System.out.println("Connection established successfully...");
            String sql = "select * from registerid where id=? and password=? and choice=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, password);
            st.setInt(3,choice);
           ResultSet rs = st.executeQuery();
           if(rs.next()){
        	   System.out.println(rs.getLong(1)+"  "+rs.getString(2));
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
