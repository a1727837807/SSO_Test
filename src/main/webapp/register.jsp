<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 翟
  Date: 2020/9/9
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <form action="account/sendCheckNum.do" method="post">

        <tr>
            <td>
                手机号：<input type="text" name="phone"/>
            </td>
            <td>
                <input type="submit" value="发送"/>
            </td>
        </tr>
    </form>
</table>
</body>
</html>
