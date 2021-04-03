<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ include file="connection.jsp" %>
<%

    String account_no=request.getParameter("account_no");
    String cash=request.getParameter("cash");
    String amount=request.getParameter("amount");
    SimpleDateFormat sd=new SimpleDateFormat("DD/MM/YY HH:MM:SS");
    java.util.Date d=new Date();
    String cus_name=request.getParameter("cus_name");

    PreparedStatement ps=con.prepareStatement("insert into cash(account_no,cash,amount,time_date,cus_name) values(?,?,?,?,?)");

    ps.setString(1,account_no);
    ps.setString(2,cash);
    ps.setString(3,amount);
    ps.setString(4,sd.format(d));
    ps.setString(5,cus_name);

    int x=ps.executeUpdate();
    if(x!=0)
        response.sendRedirect("cash.html? msg='Appiled succesfully'");


%>