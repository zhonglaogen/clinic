<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-4
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>管理员</h2><br>
<form action="/admin/adminLogin.action" method="post">
    <input type="text" name="aPhone">手机号
    <input type="text" name="aPassword">密码
    <input type="submit" value="login">
</form>


</body>
</html>
