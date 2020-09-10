<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 翟
  Date: 2020/9/9
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterMember</title>
</head>
<body>
<table>
    <form action="register.do" method="post" name="account">
    <tr>
        账号：<input type="text" name="username"><br/>
    </tr>
        <tr>
            密码：<input type="text" name="password"><br/>
        </tr>
        <tr>
            <input type="submit" value="创建">
        </tr>
    </form>
</table>
</body>
</html>
