<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/12
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        body {
            font-family: "微软雅黑";
            background-image: url("img/oldsun.jpg");
            background-size: 100% 800px;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }

        tr {
            text-align: center;
        }

        table {
            border-radius: 5px;
            border: 1px white solid;
        }

        td {

            border: 1px white solid;
        }

        .btn {
            text-indent: 20px;
            border-style: none;
            background: palevioletred;
            border-radius: 5px;
            width: 100px;
            height: 40px;
            color: white;
            letter-spacing: 20px;
            text-align: center;
        }

        .btn:hover {
            box-shadow: 0px 0px 20px paleturquoise;
            font-size: 15px;

        }

        #password, #username, #check {
            border-style: none;
            width: 250px;
            height: 50px;
            background: transparent;
            font-size: 20px;
            color: palevioletred;
        }

        tr {

            height: 50px;
        }
    </style>

</head>
<body>
<h1 style="font-size:35px;color: white" align="center">客户管理系统</h1>
<form action="${pageContext.request.contextPath}/register" method="post" onsubmit="true">
    <table align="center" width="60%" height="60%" cellspacing="0">
        <caption><h2 style="color:white">管理员注册</h2></caption>
        <tr>
            <td width="200px" style="color:palevioletred;font-size: 20px">用户名：</td>
            <td width="400px">
                <input type="text" name="username" id="username" placeholder="请输入用户名6-12字母" onblur="checkUsername()" />
                <sapn id="uspan"></sapn>
            </td>

        </tr>
        <tr>
            <td style="color:palevioletred;font-size: 20px">密码:</td>
            <td><input type="password" name="password" id="password" placeholder="请输入密码6-12数字" />
                <sapn id="pspan"></sapn>
            </td>
        </tr>
        <tr>
            <td><img src="${pageContext.request.contextPath}/checkcode" id="img" onclick="changeImage()"></td>
            <td><input type="text" name="usercheckcode" placeholder="请输入验证码" id="check" /></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="注册" class="btn" />&nbsp;&nbsp;<input type="reset" value="重置"
                                                                                             class="btn" /></td>
        </tr>
        <tr>
            <td colspan="2"><span style="color:#b2ed26">已有账号请</span><a
                    href="${pageContext.request.contextPath}/login.jsp" style="color:white">登陆</a></td>
        </tr>

    </table>
</form>
<%--取出域中的提示数据--%>
<div align="center" style="color:yellow">${msg}</div>

</body>
<script>
    //发送Ajax请求
    //原生的Ajax
    //创建Ajax请求对象
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }

    //光标离开发送
    function checkUsername() {
        var mz = document.getElementById("username").value;
        //打开链接，发送请求
        xmlhttp.open("GET", "${pageContext.request.contextPath}/checkusername?username=" + mz, true);
        xmlhttp.send();
    }

    //接收后台的相应
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var str = xmlhttp.responseText;
            if (str == 'no') {
                document.getElementById("uspan").innerHTML = "<span style='color: red'>用户名已经存在</span>"
            } else if (str == 'yes') {
                document.getElementById("uspan").innerHTML = "<span style='color:green'>用户名可以用</span>"
            }
        }
    }

    //更换验证码
    function changeImage() {
        document.getElementById("img").src = "${pageContext.request.contextPath}/checkcode?sb=" + Math.random();
    }

</script>
</html>
