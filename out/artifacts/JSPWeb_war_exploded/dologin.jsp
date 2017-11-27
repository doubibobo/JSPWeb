<%--
  Created by IntelliJ IDEA.
  User: zhuch
  Date: 2017/11/6
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h>登录成功！</h>
    <%--
        设置默认的字符集
    --%>
    <%
        request.setCharacterEncoding("utf-8");
        out.println(request.getParameter("username"));
        out.println(request.getParameter("password"));
        out.println(request.getRemoteAddr());
        String site = new String("http://www.doubibobo.cn/blogs/");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    %>
</body>
</html>
