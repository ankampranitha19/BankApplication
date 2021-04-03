package com.bank;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;


public class LoginServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement ps=null;
    public void init(ServletConfig config){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/bank";
            String user="root";
            String password="root";
           con= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name=request.getParameter("name");
String password=request.getParameter("password");
String sql="select * from bank1 where name=? and password=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                response.sendRedirect("./cash.html");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
