<%--
  Created by IntelliJ IDEA.
  User: zhuch
  Date: 2017/11/6
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>逗比波波</title>
</head>
<body>
<form action="dologin.jsp" method="post">
    <table>
        <caption>用户登录</caption>
        <tr>
            <td>
                用户名：
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                密码
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">登录</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
