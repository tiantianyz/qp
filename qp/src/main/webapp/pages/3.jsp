<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="Keywords" content="汽配,北京,北京汽配,北京汽配在线">
		<title>北京汽配在线</title>
		<meta http-equiv="Pragma" content="no-cache">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<meta content="black" name="apple-mobile-web-app-status-bar-style">
		<meta content="telephone=yes" name="format-detection">
		<link rel="stylesheet" media="all" href="css/style.css">
		<script type="text/javascript">
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
	<ul id="typeLists" class="type-list"></ul>
	<script type="text/javascript" src="js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/init.js"></script>
	<script type="text/javascript">
		var types = [{id:1,name:'专项件'},
					{id:2,name:'全车件'}]
		wx.init();
	</script>
</body>
</html>