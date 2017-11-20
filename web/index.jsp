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
    <p>程天赐，你真帅！</p>

    <%--
      变量声明，中间插入Java的代码
    --%>
    <%!
      String index = "doubibobo";
      int add(int x, int y) {
          return x*y;
      }
    %>

    <%--
      jsp脚本语言
    --%>
    <%
      out.println("大家好，我是朱传波，世界上最帅的男人！");
//      out.println(add(4,5));
    %>

    <%--
      声明表达式，表达式不以分号为结束
    --%>
    <p><%=index %></p>
    <p><%=add(4, 5)%></p>
  </body>
</html>
