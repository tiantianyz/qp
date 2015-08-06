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
		<title>北京汽配在线---修理厂信息</title>
		<meta http-equiv="Pragma" content="no-cache">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<meta content="black" name="apple-mobile-web-app-status-bar-style">
		<meta content="telephone=yes" name="format-detection">
		<link rel="stylesheet" media="all" href="<%=path %>/css/style.css?version=11">
		<style type="text/css">
			html,body{width:480px;height:100%;}
		</style>
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
	<h3 id="nav" class="nav"><p id="navFirst"></p><div id="nfWin" class="nav-first"><i class="top-angle"></i><a href="<%=path%>?typesPid=1">全车件</a><a href="<%=path%>?typesPid=2">专项件</a><a href="<%=path%>?typesPid=3">拆车件</a></div></h3>
	<div id="mc" class="m-content">
		<div class="m-child">
			<ul id="mlist" class="m-list ga-list"></ul>
			<div id="pullUp"><span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span></div>
		</div>
	</div>
	<%@ include file="common/footer.jsp"%>
	<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/init.js?version=11"></script>
	<script type="text/javascript" src="<%=path %>/js/iscroll/iscroll-probe.js"></script>
	<script type="text/javascript">
		var gtypes={1:'一类修理厂','2':'二类修理厂',3:'三类修理厂',4:'汽配城'};
		wx.initg();
	</script>
</body>
</html>