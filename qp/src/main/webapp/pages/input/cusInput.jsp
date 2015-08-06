<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=path%>">
		<meta charset="utf-8">
		<meta name="Keywords" content="汽配,北京,北京汽配,北京汽配在线">
		<title>北京汽配在线</title>
		<meta http-equiv="Pragma" content="no-cache">
		<link rel="stylesheet" media="all" href="<%=path%>/css/in.style.css">
		<link rel="stylesheet" media="all" href="<%=path%>/js/ztree/zTreeStyle.css">
		<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/ztree/jquery.ztree.all.min.js"></script>
		<script type="text/javascript">var path = '<%=path%>';</script>
	</head>
<body>
	<h3 class="header">商户信息录入</h3>
	<div class="content">
		<ul id="typeTree" class="con-left ztree"></ul>
		<div class="con-right">
			<form id="cusForm">
				<div class="one-line">
					<label>名称</label><input type="text" name="cusName" class="input"/>
				</div>
				<div class="one-line">
					<label>400分机号</label><input readonly="true" type="text" name="cusPhone" class="input"/>
				</div>
				<div class="one-line">
					<label>商家电话1</label><input type="text" name="cusPhone1" class="input"/>
				</div>
				<div class="one-line">
					<label>商家电话2</label><input type="text" name="cusPhone2" class="input"/>
				</div>
				<div class="one-line">
					<label>商家网址</label><input type="text" name="cusSite" class="input"/>
				</div>
				<div class="one-line">
					<label>商户地址</label><input type="text" name="cusAddr" class="input"/>
				</div>
				<div class="one-line">
					<label>头像</label><div id="idUploadArea1" class="upload-area"><a id="idupload1" class="ui-button" file-data="" path-data="" disabled="true">上传图片</a></div>
					<input type="hidden" id="idValue1" name="cusHeadImg"/>
				</div>
				<div class="one-line">
					<label>排序</label><input type="text" name="cusOrder" value="1" class="input"/>
				</div>
				<div class="one-line">
					<label>经营范围</label><textarea class="textarea input" readonly="true" name="cusScopeName"></textarea>
					<input type="hidden" name="cusScope"/>
				</div>
				<div class="one-line">
					<label>公司简介</label><textarea name="cusDesc" class="textarea input"></textarea>
				</div>
				<div class="one-line">
					<label>详情图片</label>
					<div class="upload-right"></div>
					<p class="icon-line"><a type-data="2" href="javascript:void(0)" name-data="cusImgs.imgsAddr" class="icon-add fl" id="iconBa"><i class="icon-add-i"></i>图片添加</a></p>
				</div>
				<div class="one-line">
					<label>备注</label><textarea name="cusRemark" class="textarea input"></textarea>
				</div>
				<div class="one-line btns" style="text-align:left;">
					<a href="javascript:void(0)" class="btn" id="cusSubmit">提交</a>
				</div>
				<input type="hidden" name="cusId" class="input"/>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="<%=path %>/js/func.upload.js"></script>
	<script type="text/javascript" src="<%=path %>/js/in.init.js"></script>
	<script type="text/javascript">
		wx.cusInit();
	</script>
</body>
</html>