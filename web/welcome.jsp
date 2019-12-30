<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h3>
		<p align="center">公 司 简 介</p>
	</h3>
	<p align="center">公司发展历程--十年,简简单单,我们只做教育</p>
	<p align="center">西部开源技术中心坚持“简单、认真、向上、负责、尊重”的经营哲学与“开源润物”包容，
		无私的价值理念，满怀着“培训提升价值，开源推动进步”的朴素信念，坚持做好Linux教育培训与技术创新的开凿者与领航者。</p>
	<p align="center">以培养优秀的Linux技术人才为己任，将自己打造成为一家学员满意、企业信赖、员工自豪、社会尊重的开源的技术中心，
		最终推动开源技术在中国健康、高速发展。</p>
	<p align="center">
		<img src="img/xikai_code.png" />
	</p>
</body>
</html>
