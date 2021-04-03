<%@page import="java.sql.*"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/bank";
    String user="root";
    String password="root";
    Connection con=DriverManager.getConnection(url,user,password);
%>