<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-7
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安排出诊医生</title>
</head>
<body>
已经出诊医生
<hr>
<table border="1">
    <tr>
        <td>医生id</td>
        <td>姓名</td>
        <td>所有预约名额</td>
        <td>剩余预约名额</td>
        <td>出诊时间</td>
    </tr>
<c:forEach items="${oDoctors}" var="doctorOut">
    <tr>
        <td>${doctorOut.doctor.dId}</td>
        <td>${doctorOut.doctor.dName}</td>
        <td>${doctorOut.itemOutTreate.dAllCount}</td>
        <td>${doctorOut.itemOutTreate.dCount}</td>
        <td>${doctorOut.}/${doctorOut.itemOutTreate.iUpDown}</td>
    </tr>

</c:forEach>


</table>
<hr>
安排
</body>
</html>
