
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>左侧栏</title>
    <style>
        body {
            background-image: url("img/星空.jpg");

            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<div>
    <br>
    <br>
    <center>
        <a href="${pageContext.request.contextPath}/findall" target="mycontent">查询所有客户</a>
        <br>
        <a href="${pageContext.request.contextPath}/addCustomer.jsp" target="mycontent">添加客户</a>
    </center>

</div>
</body>
</html>
