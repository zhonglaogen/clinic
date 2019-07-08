<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>科室管理员</title>
</head>
<body>
<h3>科室管理员</h3>
安排未来一周出诊
选择日期 iDate 上午or下午
该科室医生信息表 选择安排 接待人数
<table border="1dp">
        <c:forEach items="${dates}" var="iDate">
            <tr>
                <td>${iDate}</td>
                <td><a href="showDoctor.action?iDate=${iDate}&iUpDown=上午" >上午</a></td>
                <td><a href="showDoctor.action?iDate=${iDate}&iUpDown=下午" >下午</a></td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
