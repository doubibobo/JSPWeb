<%--
  Created by IntelliJ IDEA.
  User: zhuch
  Date: 2017/11/6
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%--
  language 指定jsp页面使用的脚本语言
  import 指定所引用的类文件
  contentType指定的编码方式
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>大帅哥</title>
</head>
<body>
<%
//    String userid = request.getParameter("userid");
//    String database = request.getParameter("database");
    String userid = (String)request.getSession().getAttribute("userid");
    int database = (int)request.getSession().getAttribute("database");
%>
<p>
    欢迎您：<%= userid%>
</p>
<p>
    <%
        if (database == 0) {
            out.println("计科1501班");
        } else {
            out.println("计科1502班");
        }
    %>
    <%--<%= database%>--%>
</p>
<form action="MemberServlet" method="post">
    <input type="text" name="userid" value="<%= userid%>" hidden>
    <input type="text" name="database" value="<%= database%>" hidden>
    <button type="submit">查看班级成员</button>
</form>
<form action="CourseServlet" method="post">
    <input type="text" name="userid" value="<%= userid%>" hidden>
    <input type="text" name="database" value="<%= database%>" hidden>
    <button type="submit">查看已开课程</button>
</form>
<form action="PersonServlet" method="post">
    <input type="text" name="userid" value="<%= userid%>" hidden>
    <input type="text" name="database" value="<%= database%>" hidden>
    <button type="submit">查看个人信息</button>
</form>
</body>
</html>



