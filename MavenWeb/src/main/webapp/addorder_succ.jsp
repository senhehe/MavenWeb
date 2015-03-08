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
    <title>订购成功</title>
	<link href="css/base.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
    <body class="index">
		<a name="top"></a>
		<div class="header">
			<div class="headerTop">
				<div class="htContent">
					<div class="hlinfo">
					<s:if test="%{#session.username!=null}">
						您好
						<span id="hlmu"><s:property value="#session.username"/></span>,
						欢迎来到YD商城!
						<a href="loginout.action">[退出] </a>|<a href="register.jsp"> 注册</a>
					</s:if>
					<s:else>
						<a href="login.jsp">请登录 </a>|<a href="register.jsp"> 注册</a>
					</s:else>
					</div>
				</div>
			</div>
		</div>
		
		<div class="body">
			<s:if test="%{#session.username!=null}">
				<div class="jszxbt">订购成功！</div>
				<div class="fhsy"><a href="viewOrder.action">查看订单</a></div>
			</s:if>
			<s:else>
				<div class="jszxbt"><a href="login.jsp">请登录！ </a></div>
			</s:else>
		</div>
		
		<div class="footer">
			<div class="footerInfo">
				<p>Copyright © 2012 SEN All rights reserved.</p>
				<p><a href="renderindex.action">主页 </a>|<a href="register.jsp">注册 </a><a href="addorder_succ.jsp#top">&nbsp;&nbsp;&nbsp;&nbsp;回顶部↑</a></p>
			</div>
		</div>
	</body>
</html>
