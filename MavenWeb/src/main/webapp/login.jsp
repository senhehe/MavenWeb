<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<title>用户登录</title>
	</head>
	<body>
		<s:form action="login">
			<s:label value="用户登录"></s:label>
			<s:textfield name="username" label="用户名" ></s:textfield>
			<s:password name="password" label="密码"></s:password>
			<s:submit value="登录"></s:submit>
			<s:reset value="重置"></s:reset>
		</s:form>
		<s:a href="register.jsp">注册</s:a>
	</body>
</html>
