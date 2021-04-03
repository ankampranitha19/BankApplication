package com.bank;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
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
String re_password=request.getParameter("re_password");
String email=request.getParameter("email");
String gender=request.getParameter("gender");
String phone=request.getParameter("phone");
int mobile=Integer.parseInt(phone);
String country=request.getParameter("country");
String state=request.getParameter("state");

String sql="insert into bank1(name,password,re_password,email,gender,phone,country,state) values(?,?,?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setString(3,re_password);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setInt(6,mobile);
            ps.setString(7,country);
            ps.setString(8,state);
            int x=ps.executeUpdate();
            PrintWriter pw=response.getWriter();
            if(x!=0)
            {
               response.sendRedirect("./login.html");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
