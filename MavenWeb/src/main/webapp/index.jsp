<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<link href="css/base.css" rel="stylesheet" type="text/css">
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<title>主页</title>
		<script language="javascript">
    var myRequest;
    function gmsp(theid){
        var sl = document.getElementById("gwsl"+theid).value;
        if(!(/^[1-9]{1,2}$/.test(sl))) {
        	document.getElementById("sucw"+theid).innerHTML = "<font color=\"red\">输入错误</font>";
        	return;
        }else {
	        document.getElementById("sucw"+theid).innerHTML = "";
	        if(window.ActiveXObject) {
	        	myRequest = new ActiveXObject("Microsoft.XMLHTTP");
	        }else{
	        	myRequest = new XMLHttpRequest();
	        }
	        myRequest.onreadystatechange = function (){
		        if(myRequest.readyState==4){
		            var ret = myRequest.responseText;
		            var regx = /.*已添加购物车.*/;
		            if(regx.test(ret)){
		            	document.getElementById("gwczt"+theid).innerHTML = ret;
		            }else {
		            	self.location.href="login.jsp";
		            }
		        }
	    	};
	        myRequest.open("GET","addcart.action?productid="+theid+"&number="+sl,true);
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
							您好<span id="hlmu"><s:property value="#session.username"/></span>,欢迎来到YD商城!
							<a href="loginout.action">[退出] </a>|<a href="register.jsp"> 注册</a>
						</s:if>
						<s:else>
							<a href="login.jsp">请登录 </a>|<a href="register.jsp"> 注册</a>
						</s:else>
					</div>
					<s:if test="%{#session.username!=null}">
						<span class="ckwddd"><a href="viewOrder.action">我的订单</a></span>
					</s:if>
					<div class="gwc"><a href="viewcart.jsp"><img src="image/gwc.jpg" style="cursor:hand"></a></div>
				</div>
			</div>
		</div>
		
		
		<div class="body">
			<div class="bigbox">
			
			
				<div class="headbox">
					<p class="headleft">
						<span>所有商品</span>
					</p>
					<p class="headmiddle">
						<span>价格</span>
					</p>
					<p class="headright">
						<span>数量</span>
					</p>
				</div>

				<!--循环开始-->
				<s:iterator value="#request.pagebean.list">
				<div class="mainbox">
					<div class="imgbox">
						<img alt="商品图片" height="120" src="<s:property value="picture"/>" width="125px;" />
					</div>
					<div class="title">
						<s:property value="name"/>
					</div>
					<div class="pricenum">
						<s:property value="price"/>
					</div>
					<div class="input">
						<input id="gwsl<s:property value="id"/>" type="text" value="1" class="Num" style="width:50px;">
						<div id="sucw<s:property value="id"/>"></div>
					</div>
					<div class="instruction">
						<s:property value="info"/>
					</div>
					<div id="gwczt<s:property value="id"/>" class="shoping">
						<s:if test="%{#session.cart.cart.containsKey(id)}">
							<font color="red">已添加购物车!</font>
						</s:if>
						<s:else>
							<img src="image/jrgwc.jpg" onclick="gmsp(<s:property value="id"/>)" style="cursor:hand">
						</s:else>
					</div>
				</div>
				</s:iterator>
				<!--循环结束-->
				<div class="bffy">
					<div class="bofosm">
						<s:if test="%{#request.pagebean.currentPage == 1}">首页&nbsp;&nbsp;上一页</s:if>
						<s:else>
							<a href="renderindex.action?pagenow=1">首页</a>&nbsp;&nbsp;
							<a href="renderindex.action?pagenow=<s:property value="#request.pagebean.currentPage-1"/>">上一页</a>
						</s:else>&nbsp;&nbsp;&nbsp;
						<s:if test="%{#request.pagebean.currentPage != #request.pagebean.totalPage}">
							<a href="renderindex.action?pagenow=<s:property value="#request.pagebean.currentPage+1"/>">下一页</a>&nbsp;&nbsp;
							<a href="renderindex.action?pagenow=<s:property value="#request.pagebean.totalPage"/>">末页</a>
						</s:if>
						<s:else>下一页&nbsp;&nbsp;末页</s:else>
					</div>
			        <div class="bofofy">
						第<s:property value="#request.pagebean.currentPage" />页&nbsp;&nbsp;&nbsp;
						共<s:property value="#request.pagebean.totalPage" />页
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="footer">
			<div class="footerInfo">
				<p>Copyright © 2012 SEN All rights reserved.</p>
				<p><a href="register.jsp">注册 </a>|<a href="login.jsp"> 登录 </a><a href="renderindex.action#top">&nbsp;&nbsp;&nbsp;&nbsp;回顶部↑</a></p>
			</div>
		</div>
	</body>
</html>