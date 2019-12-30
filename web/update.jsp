
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>修改客户信息</title>
    <style>
        table{
            border:1px palevioletred solid;
        }

        td{
            border:1px palevioletred solid;
            text-align: center;
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
    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/updateCustomer" method="post">
    <table align="center" width="65%" height="55%" border="1" cellspacing="0">
        <caption style="color: blue;font-size: 25px">修改客户信息</caption>
        <tr>
            <td>客户姓名:</td>
            <td><input type="text" name="cname" value="${updatecustomer.cname}"/></td>
        </tr>

        <tr>
            <td>客户年龄:</td>
            <td><input type="text" name="age" value="${updatecustomer.age}"/></td>
        </tr>

        <tr>
            <td>客户性别:</td>
            <td>
                <input type="radio" name="gender" value="男" />男
                <input type="radio" name="gender" value="女" />女
            </td>
        </tr>
        <tr>
            <td>客户邮箱:</td>
            <td><input type="text" name="email" value="${updatecustomer.email}"/></td>
        </tr>
        <tr>
            <td>客户电话:</td>
            <td><input type="text" name="telephone" value="${updatecustomer.telephone}"/></td>
        </tr>
        <tr>
            <td>客户备注:</td>
            <td><textarea name="description" rows="8" cols="25" >${updatecustomer.description}</textarea></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="修改" class="btn"/>&nbsp;&nbsp;<input type="reset" value="重置" class="btn"/></td>
        </tr>
    </table>

</form>
</body>
</html>
