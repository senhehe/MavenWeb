<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>出错提示页</title>
</head>
<body>
	<b>出错了！放松一下，请与管理员联系！</b>
	
	<br/><br/>
	
	<s:a href="renderindex.action">回首页</s:a>
	
	<s:property value="exception.message"/>
	</body>
</html>