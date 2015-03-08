<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登陆失败</title>
		<style type="text/css">
a {
	text-decoration: none;
	color: #123db4
}
</style>

  </head>
	<body>
		<h4>
			登陆信息有误，请重新登陆！
		</h4>
		<a href="login.jsp">返回</a>
	</body>
</html>
