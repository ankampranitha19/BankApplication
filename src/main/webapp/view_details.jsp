<!DOCTYPE html>
<html>
<body bgcolor="wheat">
<br><br><br><br>
<div style="text-align: center;"></div>
<br><br>
<div style="text-align: center;">
<h1> TRANSATION DETAILS</h1>

    <div style="text-align: center;"/>
    <%@ include file="connection.jsp" %>
    <div style="text-align: center;">
    <table border="2" cellpadding="10" align="center">
        <tr><td>account_no</td><td>cash</td><td>amount</td><td>time_date</td><td>cus_name</td></tr>
        <%

            PreparedStatement ps=con.prepareStatement("select * from cash");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
        %>
        <tr><td><%=rs.getString(1)%></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td>
            <td><%=rs.getString(4) %></td>
            <td><%=rs.getString(5)%></td>
        </tr>
        <%} %>
    </table>
</div>

</div>
</body>
</html>