<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-6-30
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        .bar{
            position:fixed;/*固定地位	不受滚动条的控制*/
            right: 0px;
            top: 0px;
        }

    </style>
</head>
<body>
<table align="2dp" border="2dp">
    <tr>
        <td>医生</td>
        <td>性别</td>
        <td>出诊日期</td>
        <td>剩余数量</td>
        <td>预约状态</td>
    </tr>
    <c:forEach items="${doctors}" var="mdoctor">
        <tr>
            <td>${mdoctor.doctor.dName }</td>
            <td>${mdoctor.doctor.dGender}</td>
            <td>${mdoctor.itemDate}</td>
            <td>${mdoctor.itemOutTreate.dCount }</td>
            <td>
                <c:choose>
                <c:when test="${mdoctor.itemOutTreate.dCount >0}">
                <a href="${pageContext.request.contextPath }
                /patient/apply.action?iId=${mdoctor.itemOutTreate.iId}">预约</a>
            </c:when>
            <c:otherwise>
                已满
            </c:otherwise>
            </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<div class="bar">
    姓名：
    ${sessionScope.get("patient").pName}<br>
    电话：
    ${sessionScope.get("patient").pPhone}<br>
    <a href="/patient/showapply.action">已预约</a>
</div>


</body>
</html>
