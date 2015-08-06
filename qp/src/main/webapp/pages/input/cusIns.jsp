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
	<div class="content">
		<ul id="typeTree" class="con-left ztree"></ul>
		<div class="con-right">
		<form id="queryForm">
		<table class="query-table">
			<tr>
				<td><label>商户名称：</label><input type="text" name="cusName" class="w-input"/></td>
				<td><a id="addBtn" href="<%=path %>/pages/input/cusInput.jsp" target="_blank" class="btn">新增</a></td>
			</tr>
			<tr>
				<td><label>车型：</label><input readonly="true" disable="true" type="text" name="typesName" class="w-input"/><input type="hidden" name="typesId"></td>
				<td><a id="queryBtn" href="javascript:void(0)" class="btn">查询</a></td>
			</tr>
		</table>
		</form>
		<table class="result-table">
			<thead>
				<tr>
					<th>商户名称</th>
					<th>400电话</th>
					<th>门头照片</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="resultBody"></tbody>
		</table>
		<div id="pages" class="pages"></div>
	</div>
	<div class="clear"></div>
	</div>
	<script type="text/javascript" src="<%=path %>/js/in.init.js"></script>
	<script type="text/javascript">
		var tpi=null;
		wx.cusIns();
	</script>
</body>
</html>