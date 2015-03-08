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
    
    <title>查看订单</title>
	<link href="css/base.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
			<script language="javascript">
    var myRequest;
    function gxgwc(theid){
        var sl = document.getElementById("nums"+theid).value;
        if(!(/^[1-9]{1,2}$/.test(sl))) {
        	alert("请正确输入商品数量!");
        	return;
        }else {
	        if(window.ActiveXObject) {
	        	myRequest = new ActiveXObject("Microsoft.XMLHTTP");
	        }else{
	        	myRequest = new XMLHttpRequest();
	        }
	        myRequest.onreadystatechange = function (){
		        if(myRequest.readyState==4){
		            var ret = myRequest.responseText;
		            var regx = /^\{.*\}$/;
		            if(regx.test(ret)){
		            	var obj = eval("("+ret+")");
		            	document.getElementById("nums"+theid).innerHTML = obj.mycart.cart[theid].number;
		            	document.getElementById("gwczje").innerHTML = "￥"+obj.mycart.totalPrice;
		            	alert("更新成功!");
		            }else {
		            	self.location.href="login.jsp";
		            }
		        }
	    	};
	        myRequest.open("POST","updatecart.action?productid="+theid+"&number="+sl,true);
	        myRequest.send(null);
        }
    }
    
</script> 
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
			<div class="mycart">我的购物车</div>
			<div class="outbox">

				<div class="head"><div class="name">商品名称</div><div class="pricemenu">价格</div><div class="num">数量</div></div>
				<hr style="height:0.5px;color:#CCCCCC">
				
				<s:if test="%{#session.cart==null||#session.cart.cart.isEmpty()}">
					<div class="hmgwn">您还没有添加商品，赶紧去选购吧！</div>
					<div class="fhsy"><a href="renderindex.action">返回首页</a></div>
				</s:if>
				<s:else>
					<!--循环开始-->
					<s:iterator value="#session.cart.cart.values()">
						<div class="inbox">
							<div class="names"><s:property value="product.name"/></div>
							<div class="price"><span>￥</span><span id="Price"><s:property value="product.price"/></span></div>
							<div class="num"><input type="text" value="<s:property value="number"/>" id="nums<s:property value="product.id"/>" class="numbers" style="width:50px;"></div>
							<div class="buttonborder"><a title="更新数量" href="javascript:gxgwc(<s:property value="product.id"/>)">更新</a></div>
							<div class="buttonborder"><a title="删除订单" onclick="alert('确定删除吗？')"  href="delcart.action?productid=<s:property value="product.id"/>">删除</a></div>
						</div>
					</s:iterator>
					
					<div class="qkgwc"><a href="removecart.action">清空购物车</a></div>
					<div class="jrjszx">
						总计：<span id="gwczje" class="gwczj">￥<s:property value="#session.cart.getTotalPrice()"/></span>
						<span class="tjdd"><a href="addorder.jsp"><img src="image/jrjszx.gif" style="cursor:hand;"/></a></span>
					</div>
					
					<!--循环结束-->
 				</s:else>
 			</div>
		</div>
		
		
		<div class="footer">
			<div class="footerInfo">
				<p>Copyright © 2012 SEN All rights reserved.</p>
				<p><a href="renderindex.action">主页 </a>|<a href="register.jsp">注册 </a><a href="viewcart.jsp#top">&nbsp;&nbsp;&nbsp;&nbsp;回顶部↑</a></p>
			</div>
		</div>
	</body>
</html>
