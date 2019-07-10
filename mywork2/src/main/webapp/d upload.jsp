<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/puyuan.css">
    <link rel="stylesheet" href="css/histogram.css">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/tools.js"></script>
    <style type="text/css">
        .se2{
            width:100px;
            height:36px;
            position:absolute;
            top:70px;
            left: 650px;
            z-index: 1;
            opacity: 0;
        }
        .se1{
            width:100px;
            height:36px;
            position:absolute;
            top:70px;
            left: 650px;
        }
        .se1:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>
<br/><br/>
<!--标题-->
<div class="navbar-centerl">
    <img class="isize" src="img/logo.png" style="display:inline">
    <h1 style="display:inline">何庄子管理员系统</h1>
</div>
<br/><br/>
<!--导航栏-->
<div class="menuk">
    <ul class="menu">
        <ul class="navbar-centerl1">
            <li><a href="dlogin.html" class="dbt">登录</a></li>
            <li><a href="dregistered.html" class="dbt">注册</a></li>
        </ul>
    </ul>
    <div class="clear"></div>
</div>
<!--巨幕-->
<div class="jumbotron big-screen">
    <img src="img/eyes.jpg">
</div>
<!--内容-->
<div class="container">
    <div class="row">
        <!--使导航栏与下方文本对齐-->
        <div class="col-sm-1"></div>
        <div class="col-sm-10 divcss">
            <br/><br/>
            <form class="login-form" action="upload/medicine.action" method="post" enctype="multipart/form-data">
                <h2 style="margin-left: -50px">请选择您要上传的文件：</h2>
                <input id="f_file" class="se2" type="file" name="file" >
                <label for="f_file">
                    <input type="button" class=" se1 login-btn" style="width: 70px" value="选择文件" />
                </label>
                <br/>
                <input type="submit" value="提交" class="login-btn" style="width: 70px;top:-20px">
            </form>
            <br/><br/><br/><br/>
            <div id="histogram" style="width: 500px;height: 300px">
                <div id="bar-chart">
                    <div class="graph">
                        <ul class="x-axis">
                            <li><span>就诊次数</span></li>
                            <li><span>预约次数</span></li>
                        </ul>
                        <ul class="y-axis">
                            <li><span>20</span></li>
                            <li><span>15</span></li>
                            <li><span>10</span></li>
                            <li><span>5</span></li>
                            <li><span>0</span></li>
                        </ul>
                        <div class="bars">
                            <div id="div01" class="bar-group">

                            </div>
                            <div id="div02" class="bar-group">

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-left: 500px;margin-top: -350px;position: absolute">
                <h2 style="margin-left: 130px;">药品销售信息</h2><br/>
                    <table id="table" width="500px" border="1">
                        <tr>
                            <td>药品名称</td>
                            <td>药品数量</td>
                            <td>药品价格</td>
                        </tr>
                    </table>
                </td>
            </div>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
<!--网页底部-->
<br/><br/>
<div class="foot1">
    <div class="main">
        <i></i>
        <div class="d1">
            <div class="bt1"><span class="s1">联系方式</span></div>
            <div class="lx_nr">
                <ul>
                    <li>地址：xxxxxxxxxxxxxxxxxxxxx</li>
                    <li>邮编：000000</li>
                    <li>电话：0022-00009999</li>
                    <li>传真：0224-00009999</li>
                    <li>Email：<a href="mailto:szwkyy@gmail.com">333@gmail.com</a></li>
                </ul>

            </div>
            <ul class="lb_wx">
                <li style="margin-right: 10px;"><img src="/img/em_wx2.jpg">
                    <p>ym</p></li>
                <li style="margin-right: 10px;"><img src="/img/em_xl2.jpg">
                    <p>zlx</p></li>
                <li style="margin-right: 10px;"><img src="/img/em_fyapp.png">
                    <p>zzj</p></li>
            </ul>
        </div>
        <div class="d2">
            <div class="bt1"><span class="s1">333专区</span></div>
            <ul class="lm1">
                <li><a class="cd_z1" target="_blank"><span>ym</span></a></li>
                <li><a class="cd_z1" target="_blank"><span>zlx</span></a></li>
                <li><a class="cd_z1" target="_blank"><span>zzj</span></a></li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="foot2">
    <div class="main">
        <ul class="cd_f1">
        </ul>
        <span class="s2 dbt"><a target="_blank"
                                href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33030202000591"><img
                src="/img/ba_03.png"/><p>天津公网安备 7e333666号</p></a></span>
        <span class="s1">版权所有：7E333<br>  Copyright &copy; 2017 Wenzhou DongHua Hospital</span>
        <div class="clear"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    function btnclick() {
        var table01 = document.getElementById("table01");
        var table02 = document.getElementById("table02");
        var btn01 = table01.getElementsByTagName("input");
        var btn02 = table02.getElementsByTagName("input");
        // console.log(btn01);
        for (var j = 1; j < btn01.length; j = j + 2) {
            btn01[j].index = j;
            var result = btn01[j - 1].innerHTML;
            btn01[j].onclick = function () {
                var result = this.parentNode.parentNode.getElementsByTagName("input")[0];
                // console.log(result.value);
                $.ajax({
                    url: "${pageContext.request.contextPath}/demo",
                    contentType: "application/json;charset-UTF-8",
                    data: JSON.stringify({result: result}),
                    type: "POST",
                    success: function (data) {
                        console.log(data);
                    }
                });
            }
        }
        for (var j = 1; j < btn02.length; j = j + 2) {
            btn02[j].index = j;
            var result = btn02[j - 1].innerHTML;
            btn02[j].onclick = function () {
                var result = this.parentNode.parentNode.getElementsByTagName("input")[0];
                // console.log(result.value);
                $.ajax({
                    url: "${pageContext.request.contextPath}/demo",
                    contentType: "application/json;charset-UTF-8",
                    data: JSON.stringify({result: result}),
                    type: "POST",
                    success: function (data) {
                        console.log(data);
                    }
                });
            }
        }

    }
    $.ajax({
        url: "${pageContext.request.contextPath}/info/all.action",
        contentType: "application/json;charset-UTF-8",
        type: "GET",
        success: function (data) {
            var medicine = data.medicines;
            var table = document.getElementById("table");
            for (var i = 0; i < medicine.length; i++) {
                var row = table.insertRow(table.rows.length);
                var c1 = row.insertCell(0);
                c1.innerHTML = medicine[i].mName;
                var c2 = row.insertCell(1);
                c2.innerHTML = medicine[i].mCount;
                var c3 = row.insertCell(2);
                c3.innerHTML = medicine[i].mPrice;
            }
            var patientTotal = data.patientTotal/0.2+"%";
            var orderTotal = data.orderTotal/0.2+"%";
            var div01 = document.getElementById("div01");
            var div02 = document.getElementById("div02");
            div01.innerHTML = " <div class='bar bar-1 stat-1' style='height:" + patientTotal + "'></div>";
            div02.innerHTML = "<div class='bar bar-8 stat-2' style='height:"+ orderTotal +";margin-left: 135px'></div>"
        }
    });
</script>
</html>