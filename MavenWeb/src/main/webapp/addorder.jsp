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
    <title>结算中心</title>
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
			<div class="jszxbt">结算中心</div>
			<s:if test="%{#session.cart==null||#session.cart.cart.isEmpty()}">
				<div class="hmgwn">您还没有选购商品，无法结算！</div>
				<div class="fhsy"><a href="renderindex.action">返回首页</a></div>
			</s:if>
			<s:else>
				<div class="orderform">
					<s:form name="shinfo" method="get">
						<s:label value="请填写收货信息"></s:label>
						<s:textfield name="linkman" label="收货人"></s:textfield>
						<s:textfield name="address" label="收货地址"></s:textfield>
						<s:textfield name="phone" label="联系电话"></s:textfield>
					</s:form>
					<span style="font-size:17px;">支付方式：线下支付</span>
				</div>
				
				<div class="outbox">
					<div class="oddxx">订单信息</div>
					<div class="head"><div class="name">商品名称</div><div class="pricemenu">价格</div><div class="num">数量</div></div>
					<hr style="height:0.5px;color:#CCCCCC">
					<s:iterator value="#session.cart.cart.values()">
						<div class="inbox">
							<div class="names"><s:property value="product.name"/></div>
							<div class="price"><span id="Price">￥<s:property value="product.price"/></span></div>
							<div class="num"><s:property value="number"/></div>
						</div>
					</s:iterator>
					<div class="jrjszx">
						总计：<span id="gwczje" class="gwczj">￥<s:property value="#session.cart.getTotalPrice()"/></span>
					</div>
				</div>
				
				<span class="tjdd"><img src="image/tjdd.png" onclick="javascript:document.shinfo.action='saveOrder.action';document.shinfo.submit();" style="cursor:hand"/></span>
			</s:else>
		</div>
		
		<div class="footer">
			<div class="footerInfo">
				<p>Copyright © 2012 SEN All rights reserved.</p>
				<p><a href="renderindex.action">主页 </a>|<a href="register.jsp">注册 </a><a href="addorder.jsp#top">&nbsp;&nbsp;&nbsp;&nbsp;回顶部↑</a></p>
			</div>
		</div>
	</body>
</html>
