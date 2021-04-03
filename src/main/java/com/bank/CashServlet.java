package com.bank;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CashServlet extends HttpServlet {
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String account_no=request.getParameter("account_no");
String cash=request.getParameter("cash");
String amt=request.getParameter("amount");
SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date d=new Date();
String cus_name=request.getParameter("cus_name");
String sql="insert into cash(account_no,cash,amount,time_date,cus_name) values(?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,account_no);
            ps.setString(2,cash);
            ps.setString(3,amt);
            ps.setString(4,sd.format(d));
            ps.setString(5,cus_name);
            int x= ps.executeUpdate();
            PrintWriter pw= response.getWriter();
            if(x!=0)
            {
               pw.println("<html><body bgcolor='wheat'><center><h1>Transaction Successfull</h1></center></html>");
               response.sendRedirect("./view_details.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
