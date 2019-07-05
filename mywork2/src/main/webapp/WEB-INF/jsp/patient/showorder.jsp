
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
        <%--下单时间，订单号--%>
    </tr>
    <c:forEach items="${orders}" var="mdoctor">
        <tr>
            <td>${mdoctor.doctor.dName }</td>
            <td>${mdoctor.doctor.dGender}</td>
            <td>${mdoctor.itemDate}</td>
            <td>
                <c:choose>
                    <c:when test="${!mdoctor.patientOrder.oGo}">
                        <a href="/patient/cancelorder.action?oId=${mdoctor.patientOrder.oId}">取消预约</a>
                    </c:when>
                    <c:otherwise>
                        已排号或超时未去
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
