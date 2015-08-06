<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="Keywords" content="汽配,北京,北京汽配,北京汽配在线">
		<title id="qtitle">北京汽配在线</title>
		<meta http-equiv="Pragma" content="no-cache">
		<meta content="no" name="apple-mobile-web-app-capable">
		<meta content="black" name="apple-mobile-web-app-status-bar-style">
		<meta content="telephone=yes" name="format-detection">
		<link rel="stylesheet" media="all" href="<%=path %>/css/style.css?version=11">
		<script type="text/javascript">
			var path ='<%=path%>';
			(function(){
				var viewPort = document.getElementById('viewPortId'),width= screen.availWidth;
				if(Math.abs(window.orientation) == 90)
					width= screen.availHeight;
				if(!viewPort){
					viewPort = document.createElement('meta');
					viewPort.id='viewPortId';
					viewPort.name='viewport'
				}
				viewPort.content='width=480,initial-scale='+width/480+',maximum-scale='+width/480+',minimum-scale='+width/480+',target-densitydpi=device-dpi,user-scalable=no';
				document.getElementsByTagName('head')[0].appendChild(viewPort);
			})(this);
		</script>
	</head>
<body>
	<div id="ads" class="q-r"></div>
	<div class="notice-line yellow-bg"><p class="notice-p notice-one">公告：<span>部分手机拨打商家400免费电话，需先拨通总机后再人工输入该商家分机号，即可接通！！！</span></p></div>
	<ul id="typeLists" class="type-list1"></ul>
	<%@ include file="common/footer.jsp"%>
	<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">var path='<%=path%>';</script>
	<script type="text/javascript" src="<%=path %>/js/init.js?version=11"></script>
	<script type="text/javascript">
		wx.initi();
	</script>
	
</body>
</html>