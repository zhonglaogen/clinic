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
<h2>Hello World!</h2>
<label>可选的科室有：1,2,3</label>
<form action="/chooseroom.action" method="get">
    <input type="text" name="rId">
    <input type="submit">
</form>
<div class="bar">
    姓名：
    ${sessionScope.get("patient").pName}<br>
    电话：
    ${sessionScope.get("patient").pPhone}<br>
    <a href="/showapply.action">已预约</a>
</div>
</body>
</html>
