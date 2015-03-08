<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<title>注册成功</title>
		<style type="text/css">
a {
	text-decoration: none;
	color: #123db4
}
</style>
	</head>
	<body>
		<h4>
			恭喜你注册成功！
		</h4>
		<a href="login.jsp">登陆</a>
	</body>
</html>
