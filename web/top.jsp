
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顶部页面</title>
    <style>
        body {
            background-image: url("img/zhouxingxing.png");
            background-size: 100%,150px;
            background-position: 0,-30px;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<h1 align="center" style="color: whitesmoke">客户管理系统</h1>
<div style="float:right;margin-top:-60px"><a href="javascript:void(0)" onclick="exitSystem()">安全退出</a></div>
<div style="float:left;color: #db11c9">${user.username} 欢迎你！</div>
<div style="clear:both;"></div>
<div id="time" style="margin-left:20px;color: aqua">2018-06-13</div>
<span id="xingqi" style="margin-left:50px;color: blue">星期一</span>
</body>
<script>
function exitSystem(){
    //请求后台进行安全退出
    if(window.confirm("你确认要退出吗？")){
        window.parent.location.href = "${pageContext.request.contextPath}/exit";
    }
}

function showTiem() {
    var date = new Date();
    var time = date.toLocaleString();
    document.getElementById("time").innerHTML = time;
}

showTiem();
window.setInterval("showTiem()", 1000);

function getWeek() {
    var sp = document.getElementById("xingqi");
    var d = new Date();
    var week = d.getDay();
    if (week == 3) {
        sp.innerHTML = "星期三  确认过眼神，遇见对的人"

    }
    if (week == 4) {
        sp.innerHTML = "星期四  愿天下有情人终成眷属"

    }
    if (week == 5) {
        sp.innerHTML = "星期五  熬过今天，就能双休"

    }
    if (week == 6) {
        sp.innerHTML = "星期六  悲催，今天还在上班"

    }
    if (week == 0) {
        sp.innerHTML = "星期天  又在上班，女朋友都快分手了"

    }
    if (week == 1) {
        sp.innerHTML = "星期一  美好的一天，从星期一开始"

    }
    if (week == 2) {
        sp.innerHTML = "星期二  天天好心情"
    }
}

getWeek();
</script>
</html>
