<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	String openId= (String)request.getSession().getAttribute("openId");
	openId = openId==null?"":openId;
 	//request.getSession().setAttribute("openId","o41g1s9ogE2DQnJ694EHzzlsrIc4");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="Keywords" content="汽配,北京,北京汽配,北京汽配在线">
		<title id="mtitle">北京汽配在线</title>
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
	<div id="md" class="md reg-rep" reg-data="cusName,cusTimes,cusPhone,cusPhone1,cusPhone2,cusId,cusScope,cusAddr,cusSite,cusDesc">
		<h3>#(cusName)</h3>
		<p class="oper-a" style="padding:0;">
			<a href="javascript:void(0)" onclick="javascript:wx.removeCol(this,'#(cusId)')" id="colId" class="show-t fl"><i class="col-i col-i-n"></i>收藏</a>
			<a href="javascript:void(0)" onclick="javascript:wx.addLaud(this,'#(cusId)');" id="dzId" class="show-t"><i class="dz-i"></i>赞</a>
			<a href="tel:4008190789,5493" class="show-t fr" style="color:#333" cus-data="512"><img class="tel-img" src="/images/tel.gif">拨打#(cusTimes)次</a>
		</p>
		<p>主营：<span>#(cusScope)</span></p>
		<p>电话：<span><a cus-data="#(cusId)" href="tel:4008190789,#(cusPhone)">4008190789,#(cusPhone)</a>　<a class="one-tel" cus-data="#(cusId)" href="tel:4008190789,#(cusPhone)"">免费拨号</a><br>
			<a cus-data="#(cusId)" href="tel:#(cusPhone1)">#(cusPhone1)</a><br>
			<a cus-data="13" href="tel:#(cusPhone2)">#(cusPhone2)</a></span><br>
		</p>
		<p class="notice-p">公告：<span>部分手机拨打商家400免费电话，需先拨通总机后再人工输入该商家分机号，即可接通！！！</span></p>
		<p>地址：<span>#(cusAddr)</span></p>
		<p>简介：<span>#(cusDesc)</span></p>
		<p>网站：<span><a href="#(cusSite)">#(cusSite)</a></span></p>
	</div>
	<h3 class="imgs-t">图文介绍</h3>
	<div id="imgs" class="imgs"></div>
	<div class="wx-infos">
		<p><img src="<%=path%>/images/wx.png"></p>
		<p>微信号：<span class="wx-a">qpzx360(汽配在线)</span></p>
	</div>
	<%@ include file="common/footer.jsp"%>
	<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">var path = '<%=path%>'</script>
	<script type="text/javascript" src="<%=path %>/js/init.js?version=11"></script>
	<script type="text/javascript">
			var openId='<%=openId%>';
 			//var openId='o41g1s9ogE2DQnJ694EHzzlsrIc4';
			if(!openId) wx.codeOper();
			else wx.initmd();
	</script>
</body>
</html>