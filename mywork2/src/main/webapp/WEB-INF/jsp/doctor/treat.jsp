<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-4
  Time: 下午8:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
开始诊治（将当前状态改为诊治状态）<br>
诊治单<br>
姓名：${myArrange.patient.pName}<br>
<form action="/doctor/outResult.action?">
    诊治结果:<input type="text" name="tResult">
    (诊治结果包含药品信息)
    治疗方式：<input type="radio" name="tType" value="0">修养
    <br>
    <input type="radio" name="tType" value="1">吃药
    <input type="radio" name="tType" value="2">吃药和注射
    <br><br>
    <input type="submit">
</form>





结束诊治（删除队列中的人,回到医生主界面）
</body>
</html>
