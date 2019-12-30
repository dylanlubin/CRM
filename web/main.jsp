<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<c:if test="${not empty user}">
    <frameset rows="30%,*" border="1" noresize="noresize">
        <frame src="${pageContext.request.contextPath}/top.jsp" />
        <frameset cols="20%,*" noresize="noresize">
            <frame src="${pageContext.request.contextPath}/left.jsp" />
            <frame src="${pageContext.request.contextPath}/welcome.jsp" name="mycontent" />
        </frameset>
    </frameset>
</c:if>
<c:if test="${empty user}">
    你尚未登录，请重新<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
</c:if>
</html>
