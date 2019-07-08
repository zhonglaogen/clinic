<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-3
  Time: 下午2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>诊治医师</title>
</head>
<body>
排号人数：：：：：：：：排号名单
<hr>
1.叫号（叫号三次不来就换下一位）<br>
<a href="/doctor/callNum.action">叫号</a><br>
<c:if test="${myArrange!=null}">
    等待::${myArrange.patient.pName}<br>
</c:if>
2.来了，进入treat<br>
<a href="/doctor/showTreat.action">来了</a><br>
3.三次未到<br>
<a href="/doctor/nextNum.action">三次未到</a>
</body>
</html>
