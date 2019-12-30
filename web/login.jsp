<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/12
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <style>
        body {
            background-image: url("img/login.jpg");
            background-repeat: no-repeat;
            background-size: 100% 800px;
            background-attachment: fixed;
            text-align: center;

        }

        #box {
            padding-top: 50px;
            text-align: center;
            margin: auto;
            border: 0px white solid;
            width: 500px;
            height: 300px;

        }

        .nei {

            margin: auto;
            margin-top: 20px;
            border-radius: 15px;
            border: 1px white solid;
            width: 400px;
            height: 40px;
        }
        .nei:active{
            box-shadow: 0px 0px 30px palevioletred;
        }
        .in {
            font-size: 20px;
            text-align: center;
            color: palevioletred;
            width: 300px;
            height: 40px;
            background: transparent;
            border-style: none;
        }

        input[type=submit] {
            text-align: center;
            font-size: 28px;
            background: transparent;
            color: white;
            width: 300px;
            height: 40px;
            border-style: none;
            letter-spacing: 50px;
            text-indent: 40px;

        }

        #login:hover {
            background: palevioletred;

        }

        #showpwd {
            width: 50px;
            height: 30px;
            border: 0px white solid;
            position: absolute;
            left: 850px;
            top: 145px;
            background-image: url("img/showpwd.png");
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }
        #showpwd:hover{
              cursor: pointer;
        }

    </style>

</head>
<body>
<div id="showpwd" onmousedown="showPwd()" onmouseup="hiddenPwd()"></div>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div id="box">

        <div class="nei"><input type="text" name="username" placeholder="请输入用户名" class="in" value="${cookie.username.value}"/></div>
        <div class="nei"><input type="password" name="password" placeholder="请输入密码" class="in" id="pwd" value="${cookie.password.value}"/>
        </div>
        <%--<div style="clear: both"></div>--%>
        <div class="nei" style="color: white;padding-top: 7px;box-sizing: border-box;">记住密码
            <input type="radio" name="rember"
                   value="7"/>一周
            <input type="radio" name="rember" value="30"/>一个月
        </div>
        <div class="nei" id="login">
            <input type="submit" value="登陆"/>
        </div>
        <div align="center" style="color:red">
           ${msg}
        </div>
    </div>
</form>

<script>
    function showPwd() {
        document.getElementById("pwd").type = "text";
    }

    function hiddenPwd() {
        document.getElementById("pwd").type = "password";
    }
</script>
</body>
</html>
