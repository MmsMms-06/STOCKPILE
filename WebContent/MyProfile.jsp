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
String email = (String)session.getAttribute("email");
System.out.println("Email:"+request.getParameter("email"));
PreparedStatement statement = null;
Connection connection = null;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/MySurvey.css">
<script src="JavaScript/About.js"></script>

<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<div>
<h1><img src="Images/logo.jpg" alt="STOCKPILE"></h1>
<ul>
<li><div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a class="passive" href="about.html">About</a>
  <div class="con"><a class="passive" href="contact.html">Contact</a>
  <div class="dropdown-content">
  <p>Email:stockpile@mail.com</p>
  <p>Contact:1800-456-546</p>
  <p>Address:Bangalore,Karnataka</p>
  </div>
  </div>
  <a class="passive" href="faq.html">FAQ's</a>
  <a class="passive" href="login.html">LogOut</a>
</div>
<div id="main">
  <span class="button" onclick="openNav()">&#9776;</span>
  </div></li>
<li><a  href="admin.html">Home</a></li>
  <li><a href="createsurvey.html">Create a survey</a></li>
  <li><a href="mysurveys.html">My Surveys</a></li>
  <li><a  href="about.html">About</a></li>
    <li><a class="active" href="MyProfile.jsp">My Profile</a></li>
 </ul>
</div>
<%
try {
   
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded successfully..");
    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
    System.out.println("Connection established successfully...");
    String sql = "select * from account where email=?";
    statement=connection.prepareStatement(sql);
    statement.setString(1,email);
   ResultSet rs = statement.executeQuery();
   while(rs.next()){
%>
UserName:- <%=rs.getString("username") %><br><br>
Email:- <%=rs.getString("email") %><br><br>
Gender:- <%=rs.getString("gender") %><br><br>
Date Of Birth:- <%=rs.getString("dateofbirth") %><br><br>
MobileNumber:- <%=rs.getString("mobilenumber") %><br><br>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>