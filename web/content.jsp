<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>内容页</title>
    <style>
        body {
            background-image: url("img/xingye.jpg");

            background-repeat: no-repeat;
        }
        table {
            border: 1px palevioletred solid;
        }

        th {
            border: 1px palevioletred solid;
        }

        td {
            border: 1px palevioletred solid;
            text-align: center;
        }
    </style>

</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/queryall" method="post">
        客户姓名:<input type="" name="customername" />
        客户电话：<input type="" name="phonenumber"/>
        <input type="submit" value="查询"/>

    </form>
</center>

<form action="${pageContext.request.contextPath}/delall" method="post" onsubmit="return sureDel()">

    <table width="80%" height="60%" border="1" cellspacing="0" align="center">
        <caption style="font-size: 25px;color:blue">客户信息</caption>
        <tr>
            <th><input type="checkbox" name="top_checkbox" onclick="testMethod(this)"/></th>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="customer" varStatus="v">
            <tr>
                <td><input type="checkbox" name="item_checkbox" value="${customer.cid}"/></td>
                <td>${v.count}</td>
                <td>${customer.cname}</td>
                <td>${customer.age}</td>
                <td>${customer.gender}</td>
                <td>${customer.email}</td>
                <td>${customer.telephone}</td>
                <td>${customer.description}</td>
                    <%--//将cid传给这个函数--%>
                    <%--根据客户的id来删除一客户--%>
                <td>
                    <a href="#" onclick="delCustomer('${customer.cid}')">删除</a>
                    &nbsp;&nbsp;
                    <a href="#" onclick="changeCustomer('${customer.cid}')">修改</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8" align="center">
                <input type="button" value="全选" onclick="allChecked()"/>
                <input type="button" value="反选" onclick="reverseChecked()"/>
                <input type="submit" value="删除选中"/>
            </td>
        </tr>
    </table>
</form>

<script>
    //修改用户信息
    function changeCustomer(cid) {
        window.location.href = "${pageContext.request.contextPath}/preparedupdateCustomer?cid=" + cid;
    }

    function sureDel() {
        return window.confirm("你确认删除所选吗？")
    }

    function delCustomer(cid) {
        if (window.confirm("你要确定删除吗?")) {
            //请求后台进行删除
            window.location.href = "${pageContext.request.contextPath}/delCustomer?cid=" + cid;
        }
    }

    //全选
    function allChecked() {
        var arr = document.getElementsByName("item_checkbox");
        for (var i = 0; i < arr.length; i++) {
            arr[i].checked = true;
        }
    }

    //反选：勾上的去掉勾，没勾的勾上
    function reverseChecked() {
        var arr = document.getElementsByName("item_checkbox");
        for (var i = 0; i < arr.length; i++) {
            /*  if(arr[i].checked){
                  arr[i].checked = false;
              }else{
                  arr[i].checked = true;
              }*/
            arr[i].checked = !arr[i].checked;
        }
    }

    //同步选
    function testMethod(obj) {
        var arr = document.getElementsByName("item_checkbox");
        for (var i = 0; i < arr.length; i++) {
            arr[i].checked = obj.checked;
        }
    }

</script>