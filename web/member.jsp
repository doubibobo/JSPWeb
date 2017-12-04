<%@ page import="com.mysql.jdbc.JDBC42ResultSet" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.UserListBeans" %><%--
  Created by IntelliJ IDEA.
  User: zhuch
  Date: 2017/12/4
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级成员信息</title>
</head>
<body>
    <%
        ArrayList userlist = (ArrayList)request.getAttribute("allMember");
        int database = (int)request.getSession().getAttribute("database");
    %>
        <h2 align="center">同学列表</h2>
        <table align="center">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
            </tr>
        </table>
        <%
        for (int i = 0; i < userlist.size(); i++) {
            UserListBeans userListBeans = (UserListBeans) userlist.get(i);
        %>
        <tr>
            <th><% out.println(userListBeans.getUserid() + "    " + userListBeans.getUsername() + "    " + userListBeans.getSex());%></th>
        </tr>
        <%
        }
        %>
</body>
</html>
