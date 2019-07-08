<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-4
  Time: 上午4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导诊</title>
</head>
<body>
<h4>此科室为：${aroom.rName}</h4>
注意：必须到预约相对应的科室进行排号，否则排号失败<br>
请输入预约当日的手机号
<form action="/admin/arrange.action?">
    <input type="text" name="aPhone">
    <input type="submit" value="排号">
</form>
</body>
</html>
