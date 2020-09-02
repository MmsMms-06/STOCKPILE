<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%
int id = (int)session.getAttribute("id");
System.out.println("id:"+request.getParameter("id"));
String password = request.getParameter("password");
int choice = (int)session.getAttribute("choice");
System.out.println("id:"+request.getParameter("choice"));
PreparedStatement statement = null;
Connection connection = null;
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="CSS/Response.css">
<style>
body{
background-image: url("Images/d5.jpg");
 background-repeat:no-repeat;
 position:relative;
top:20%;
left:10%;
}
input[type=text] {
  width: 40%;
  }
</style>
<body>
<b>
<h1>STOCKPILE</h1>
<%
if(choice<2){
try {
	
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded successfully..");
    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
    System.out.println("Connection established successfully...");
    String sql = "select * from registera where id=?";
    statement=connection.prepareStatement(sql);
    statement.setInt(1, id);
   ResultSet rs = statement.executeQuery();
   while(rs.next()){
%>
<div class="v"></div>
<form action="Registers">
<%=rs.getString("name") %><br><br>
<input type="text" name="name"><br><br>
<%=rs.getString("surname") %><br><br>
<input type="text" name="surname"><br><br>
<%=rs.getString("email") %><br><br>
<input type="text" name="email"><br><br>
<%=rs.getString("gender") %><br><br>
<input type="text" name="gender"><br><br>
<%=rs.getString("address") %><br><br>
<input type="text" name="address"><br><br>
<%=rs.getString("mobilenumber") %><br><br>
<input type="text" name="mobilenumber"><br><br>
<button class="button">Submit</button><br>
</form>
</div>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
}
else if(choice>1){
	try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	    System.out.println("Driver loaded successfully..");
	    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
	    System.out.println("Connection established successfully...");
	    String sql = "select * from registerb where id=?";
	    statement=connection.prepareStatement(sql);
	    statement.setInt(1, id);
	   ResultSet rs = statement.executeQuery();
	   while(rs.next()){
%>
<div class="v">
<form action="Registers">
<%=rs.getString("name") %><br><br>
<input type="text" name="name"><br><br>
<%=rs.getString("surname") %><br><br>
<input type="text" name="surname"><br><br>
<%=rs.getString("email") %><br><br>
<input type="text" name="email"><br><br>
<%=rs.getString("dateofbirth") %><br><br>
<input type="date" name="dateofbirth"><br><br>
<%=rs.getString("gender") %><br><br>
<input type="text" name="gender"><br><br>
<%=rs.getString("caste") %><br><br>
<input type="text" name="caste"><br><br>
<%=rs.getString("religion") %><br><br>
<input type="text" name="religion"><br><br>
<%=rs.getString("nation") %><br><br>
<input type="text" name="nation"><br><br>
<%=rs.getString("address") %><br><br>
<input type="text" name="address"><br><br>
<%=rs.getString("mobilenumber") %><br><br>
<input type="text" name="mobilenumber"><br><br>
<button class="button">Submit</button><br>
</form>
</div>
<% 
	   }
	   connection.close();
	   } catch (Exception e) {
	   e.printStackTrace();
	   }
	   }
%>
