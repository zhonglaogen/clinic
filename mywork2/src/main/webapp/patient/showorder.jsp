
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-1
  Time: 下午6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="2dp" border="2dp">
    <tr>
        <td>医生</td>
        <td>性别</td>
        <td>出诊日期</td>
    </tr>
    <c:forEach items="${orders}" var="mdoctor">
        <tr>
            <td>${mdoctor.doctor.dName }</td>
            <td>${mdoctor.doctor.dGender}</td>
            <td>${mdoctor.itemDate}</td>
            <td><a href="javascript:void(0) ">取消预约</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
