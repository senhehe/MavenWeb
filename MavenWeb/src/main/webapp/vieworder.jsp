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
    <title>我的订单</title>
	<link href="css/base.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<style>
		span{display:-moz-inline-box; display:inline-block; width:150px;text-align:center;}
	</style>
  </head>
  
    <body class="index">
		<a name="top"></a>
		<div class="header">
			<div class="headerTop">
				<div class="htContent">
					<div class="hlinfo">
					<s:if test="%{#session.username!=null}">
						您好	<p id="hlmu" class="user"><s:property value="#session.username"/></p>,
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
			<div class="jszxbt">我的订单</div>
			<s:if test="%{#session.myorder==null||#session.myorder.isEmpty()}">
				<div class="hmgwn">您没有订单！</div>
				<div class="fhsy"><a href="renderindex.action">返回首页</a></div>
			</s:if>
			<s:else>
				
				<div class="outbox">
					
					<div class="vo">
						<span>订单ID</span>
						<span>总金额</span>
						<span>订单时间</span>
						<span>订单状态</span>
						<span>详细</span>
					</div>
					<hr style="height:0.5px;color:#CCCCCC">
					<s:iterator value="#session.myorder">
						<div class="inbox">
							<span><s:property value="id"/></span>
							<span><s:property value="totalprice"/></span>
							<span><s:property value="orderdate"/></span>
							<span>
								<s:if test="%{status==1}"><font color="red">进行中</font></s:if>
								<s:elseif test="%{status==2}">已完成</s:elseif>
							</span>
							<span><a href="viewOrderItems.action?orderid=<s:property value="id"/>">详细</a></span>
						</div>
					</s:iterator>
				</div>
				<div class="thefhsy"><a href="renderindex.action">返回首页</a></div>
			</s:else>
		</div>
		
		<div class="footer">
			<div class="footerInfo">
				<p>Copyright © 2012 SEN All rights reserved.</p>
				<p><a href="renderindex.action">主页 </a>|<a href="register.jsp">注册 </a><a href="vieworder.jsp#top">&nbsp;&nbsp;&nbsp;&nbsp;回顶部↑</a></p>
			</div>
		</div>
	</body>
</html>
