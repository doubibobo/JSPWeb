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
    <%--判断所填的信息是否符合要求--%>
    <script type="text/javascript">
        function check(form) {
            if(document.forms.theLogin.username.value == "") {
                alert("请输入用户名");
                document.forms.theLogin.username.focus();
                return false;
            }
            if(document.forms.theLogin.password.value == "") {
                alert("请输入密码");
                document.forms.theLogin.password.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<form action="LoginServlet" method="post" name="theLogin">
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
                <button type="submit" name="submit" onclick="return check(this)">登录</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
