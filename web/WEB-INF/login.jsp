<%--
  Created by IntelliJ IDEA.
  User: h00918
  Date: 2020/12/26
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<center>
    <h1 style="color:red">登录</h1>
    <form id="indexform" name="indexForm" action="login.action" method="post">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password">
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="登录" style="color:#BC8F8F">
    </form>
    <form action="zhuce.jsp">
        <input type="submit" value="注册" style="color:#BC8F8F">
    </form>
</center>
</body>
</html>
