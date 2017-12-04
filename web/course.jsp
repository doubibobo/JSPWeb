<%@ page import="com.mysql.jdbc.JDBC42ResultSet" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.UserListBeans" %>
<%@ page import="bean.CourseListBeans" %><%--
  Created by IntelliJ IDEA.
  User: zhuch
  Date: 2017/12/4
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
</head>
<body>
<%
    ArrayList course = (ArrayList)request.getAttribute("allCourse");
    int database = (int)request.getSession().getAttribute("database");
%>
<h2 align="center">课程列表</h2>
<table align="center">
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>开课时间</th>
    </tr>
</table>
<%
    for (int i = 0; i < course.size(); i++) {
        CourseListBeans userListBeans = (CourseListBeans) course.get(i);
%>
<tr>
    <th><% out.println(userListBeans.getCouseid() + "    " + userListBeans.getCousename() + "    " + userListBeans.getCouseday());%></th>
</tr>
<%
    }
%>
</body>
</html>
