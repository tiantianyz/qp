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
	</head>
<body>
	<script type="text/javascript">
		var redirectUri = window.localStorage.getItem('redirect_uri');
		window.localStorage.removeItem('redirect_uri');
		window.location.href=redirectUri;
	</script>
</body>
</html>