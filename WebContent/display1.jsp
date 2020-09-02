<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
int id = (int)session.getAttribute("id");
System.out.println("id:"+id);
PreparedStatement statement = null;
Connection connection = null;
%>
<!DOCTYPE html>
<html>
<body>
<link rel="stylesheet" href="CSS/Display.css">
<h1><img src="Images/logo2.jpg" alt="STOCKPILE"></h1><br>
<%
try {
	
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded successfully..");
    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
    System.out.println("Connection established successfully...");
    String sql = "select count(*) from response where id=?";
    statement=connection.prepareStatement(sql);
    statement.setInt(1, id);
    int r = statement.executeUpdate();
    System.out.println(r);
    if(r>0){
   ResultSet rs = statement.executeQuery();
   System.out.println(rs);
   String Countrow="";
   while(rs.next()){
 %>
<label class="v"><b>Responses:<%= rs.getString(1)%></b></label><br><br>
<%   
 }
    }
    else{
    	%>
    	<h2></h2>
    	<%
    }
connection.close();

} catch (Exception e) {
e.printStackTrace();
}
%>
<%
try {
	
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded successfully..");
    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
    System.out.println("Connection established successfully...");
    String sql = "select * from question where id=?";
    statement=connection.prepareStatement(sql);
    statement.setInt(1, id);
    int r = statement.executeUpdate();
    System.out.println(r);
    if(r>0){
   ResultSet rs = statement.executeQuery();
   System.out.println(rs);
   %>
   <table id="customers">
<tr>
<th>Id</th>
<th>Question1</th>
<th>Question2</th>
<th>Question3</th>
<th>Question4</th>
<th>Question5</th>

</tr>
<% 
   while(rs.next()){
%>
<tr>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("q1") %></td>
<td><%=rs.getString("q2") %></td>
<td><%=rs.getString("q3") %></td>
<td><%=rs.getString("q4") %></td>
<td><%=rs.getString("q5") %></td>
</tr><br>
<%
}
    }
    else{
%>
<h2>Survey not Created or No Responses</h2>
<%
    	
    }
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<%
try {
	
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("Driver loaded successfully..");
    connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system" ,"system");
    System.out.println("Connection established successfully...");
    String sql = "select * from response where id=?";
    statement=connection.prepareStatement(sql);
    statement.setInt(1, id);
    int r = statement.executeUpdate();
    System.out.println(r);
    if(r>0){
   ResultSet rs = statement.executeQuery();
%>
<table id="customers">
<tr>
<th>Id</th>
<th>Email</th>
<th>Answer1</th>
<th>Answer2</th>
<th>Answer3</th>
<th>Answer4</th>
<th>Answer5</th>
</tr>
<%
   while(rs.next()){
%>
<tr>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getString("answer1") %></td>
<td><%=rs.getString("answer2") %></td>
<td><%=rs.getString("answer3") %></td>
<td><%=rs.getString("answer4") %></td>
<td><%=rs.getString("answer5") %></td>
</tr><br>
<%
   }
    }
    else{
    	%>
    	<h2>NO RESPONSES</h2>
    	<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<button id="btnExport" style="vertical-align:middle"><span>Download</span></button>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="table2excel.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $("#btnExport").click(function () {
            $("#customers").table2excel({
                filename: "Question.xls"
            });
            $("#customers").table2excel({
                filename: "Answers.xls"
            });
        });
    });
</script>
</body>
</html>