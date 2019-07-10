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
        <td>添加名额</td>
    </tr>
<c:forEach items="${oDoctors}" var="doctorOut">
    <tr>
        <td>${doctorOut.doctor.dId}</td>
        <td>${doctorOut.doctor.dName}</td>
        <td>${doctorOut.itemOutTreate.dAllCount}</td>
        <td>${doctorOut.itemOutTreate.dCount}</td>
        <td>${doctorOut.itemOutTreate.iDate}/${doctorOut.itemOutTreate.iUpDown}</td>
        <td>
            <form action="/admin/addCount.action?">
                    <input type="hidden" value="${doctorOut.itemOutTreate.iId}" name="iId">
                <input type="text" name="dAllCount"><input type="submit" value="添加">
            </form>
           </td>
    </tr>

</c:forEach>


</table>
<hr>
安排<br>
<table border="1">
    <tr>
        <td>医生id</td>
        <td>姓名</td>
        <td>所有预约名额</td>
    </tr>
    <c:forEach items="${noDoctors}" var="noOutDoctor">
        <tr>
            <td>${noOutDoctor.dId}</td>
            <td>${noOutDoctor.dName}</td>
            <td>
                <form action="/admin/addOutTreat.action">
                    <input type="hidden" value="${noOutDoctor.dId}" name="dId">
                    <input type="text" name="dAllCount" >
                    <input type="submit" value="出诊">
                </form>
            </td>
        </tr>

    </c:forEach>
</body>
</html>
