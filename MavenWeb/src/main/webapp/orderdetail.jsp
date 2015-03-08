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
    <title>订单详情</title>
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
			<div class="jszxbt">订单详情</div>
			<s:if test="%{#session.theitems==null||#session.theitems.isEmpty()}">
				<div class="hmgwn">没有此订单信息！</div>
				<div class="fhsy"><a href="viewOrder.action">返回</a></div>
			</s:if>
			<s:else>
				<div class="orderformdt">
					<s:iterator value="#session.theitems.keySet()">
						<div><span>收货人</span><span><s:property value="linkman"/></span></div>
						<div><span>收货地址</span><span><s:property value="address"/></span></div>
						<div><span>联系电话</span><span><s:property value="phone"/></span></div>
					</s:iterator>
				</div>
				
				<div class="outbox">
					<div class="head"><div class="name">商品名称</div><div class="pricemenu">价格</div><div class="num">数量</div></div>
					<hr style="height:0.5px;color:#CCCCCC">
					<s:iterator value="#session.theitems.values().iterator().next()">
						<div class="inbox">
							<div class="names"><s:property value="product.name"/></div>
							<div class="price"><span id="Price">￥<s:property value="product.price"/></span></div>
							<div class="num"><s:property value="number"/></div>
						</div>
					</s:iterator>
				</div>
				<div class="thefhsy"><a href="viewOrder.action">返回</a></div>
			</s:else>
		</div>
		
		<div class="footer">
			<div class="footerInfo">
				<p>Copyright © 2012 SEN All rights reserved.</p>
				<p><a href="renderindex.action">主页 </a>|<a href="register.jsp">注册 </a><a href="orderdetail.jsp#top">&nbsp;&nbsp;&nbsp;&nbsp;回顶部↑</a></p>
			</div>
		</div>
	</body>
</html>
