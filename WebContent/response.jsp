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
PreparedStatement statement = null;
Connection connection = null;
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="CSS/Response.css">
<body>
<b>

<h1>STOCKPILE</h1>
<%
try {
	
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded successfully..");
    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
    System.out.println("Connection established successfully...");
    String sql = "select q1,q2,q3,q4,q5 from question where id=?";
    statement=connection.prepareStatement(sql);
    statement.setInt(1, id);
   ResultSet rs = statement.executeQuery();
   while(rs.next()){
%>
<form action="Response">
<%=rs.getString("q1") %><br><br>
<input type="text" name="answer1"><br><br>
<%=rs.getString("q2") %><br><br>
<input type="text" name="answer2"><br><br>
<%=rs.getString("q3") %><br><br>
<input type="text" name="answer3"><br><br>
<%=rs.getString("q4") %><br><br>
<input type="text" name="answer4"><br><br>
<%=rs.getString("q5") %><br><br>
<input type="text" name="answer5"><br><br>
<button class="button">Submit</button><br>
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</b>
</body>
</html>