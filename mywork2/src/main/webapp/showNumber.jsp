<%--
  Created by IntelliJ IDEA.
  User: zhonglianxi
  Date: 19-7-9
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>排号队列</title>
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>

        $(document).ready(function () {
            $("#findRname").on('click',function () {
                alert("click")
                var rName = $("input[name='rName']").val();
                var tbody = window.document.getElementById("tbody-result");
                var json={'rName':rName};
                $.ajax({
                    url: "${pageContext.request.contextPath}/showNum.action",
                    data:json,
                    type:"POST",
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: function (msg) {
                            var str = "";
                            for (var i in msg) {

                                str += "<tr>" +
                                    "<td align='center'>" + msg[i].dId + "</td>" +
                                    "<td align='center'>" + msg[i].dName + "</td>" +
                                    "<td align='center'>" + msg[i].rId + "</td>" +
                                    "</tr>";
                            // }
                            tbody.innerHTML = str;
                        }
                    },
                    error: function () {
                        alert("查询失败")
                    }

                });
            });
        });

    </script>
</head>
<body>

    <input type="text" name="rName">
    <input type="button" name="findRname" id="findRname" value="查询">

科室名称：<input type="hidden" name="rName">

<table id="table-result" border="1">
    <tr>
        <td>诊室</td>
        <td>医生</td>
        <td>正在就诊</td>
        <td>等待就诊</td>
        <td>排队数目</td>
    </tr>
    <tbody id="tbody-result">
    </tbody>
</table>

</body>
</html>
