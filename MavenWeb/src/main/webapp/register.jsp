<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<title>用户注册</title>
	</head>
	<body>
		<sx:head parseContent="true"/>
		<s:form action="reg">
			<s:label value="用户注册"></s:label>
			<s:textfield name="username" label="用户名" ></s:textfield>
			<s:password name="password" label="密码"></s:password>
			<s:password name="password2" label="确认密码"></s:password>
			<s:radio list="#{'1':'男','2':'女'}" name="sex" label="性别" value="1"></s:radio>
			<sx:datetimepicker label="生日" name="birthday" displayFormat="yyyy-MM-dd"/>
			<s:textfield name="email" label="邮箱"></s:textfield>
			<s:submit value="提交"></s:submit>
			<s:reset value="重置"></s:reset>
		</s:form>
		<s:a href="login.jsp">登录</s:a>
	</body>
</html>
