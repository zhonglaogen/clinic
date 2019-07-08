<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h2>每人每天可预约两次，同科室可约一次</h2>
<label>可选的科室有：1,2,3</label>
<form action="/patient/chooseroom.action" method="get">
    <input type="text" name="rId">
    <input type="submit">
</form>
<div class="bar">
    <c:choose>
        <c:when test="${patient!=null}">
        姓名：
        ${sessionScope.get("patient").pName}<br>
        电话：
        ${sessionScope.get("patient").pPhone}<br>
        <a href="/patient/showapply.action">已预约</a>
        </c:when>
    <c:otherwise>
        <<a href="/userlogin.jsp">请登录</a>
    </c:otherwise>
    </c:choose>

</div>
</body>
</html>
