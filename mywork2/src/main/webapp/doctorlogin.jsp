<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-5
  Time: 下午1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>医生</h2><br>
<form action="/doctor/doctorLogin.action" method="post">
    <input type="text" name="dPhone">手机号
    <input type="text" name="dPassword">密码
    <input type="submit" value="login">
</form>
</body>
</html>
