<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
int id = (int)session.getAttribute("id");
System.out.println("id:"+id);
int choice = (int)session.getAttribute("choice");
System.out.println("choice:"+choice);
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
    String sql = "select count(*) from formb where id=?";
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
    String sql = "select * from formb where id=?";
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
<th>mail</th>
<th>Name</th>
<th>Surname</th>
<th>Email</th>
<th>DateofBirth</th>
<th>Gender</th>
<th>Caste</th>
<th>Religion</th>
<th>Nation</th>
<th>Address</th>
<th>MobileNumber</th>
</tr>
<%
   while(rs.next()){
%>
<tr>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("mail") %></td>
<td><%=rs.getString("name") %></td>
<td><%=rs.getString("surname") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getString("dateofbirth") %></td>
<td><%=rs.getString("gender") %></td>
<td><%=rs.getString("caste") %></td>
<td><%=rs.getString("religion") %></td>
<td><%=rs.getString("nation") %></td>
<td><%=rs.getString("address") %></td>
<td><%=rs.getString("mobilenumber") %></td>
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
                filename: "Table.xls"
            });
        });
    });
</script>
</body>
</html>


