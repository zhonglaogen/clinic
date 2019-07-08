<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-6
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药品管理员</title>
</head>
<body>
<h3>药品管理员</h3>
查看所有药品${test}
<table align="2dp" border="2dp">
    <tr>
        <td>药品id</td>
        <td>药品名</td>
        <td>药品价格</td>
        <td>药品数量</td>
        <td>是否添加</td>
    </tr>
    <c:forEach items="${medics}" var="medic">
        <tr>
            <td>${medic.mId}</td>
            <td>${medic.mName}</td>
            <td>${medic.mPrice}￥</td>
            <td>${medic.mCount}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
