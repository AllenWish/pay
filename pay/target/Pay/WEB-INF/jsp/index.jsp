<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>web欢迎页</title>
<style>
.time {
	margin: 5px;
	float: right;
}
</style>
</head>
<body>
	<div id="now" class="time"></div>
	<hr>
	O(∩_∩)O哈哈~web
	<hr>
	${pageContext.request.contextPath}/
	<hr>
	<input type="button" value="^_^"
		onclick="javascript:location.href='/pay/showOutpay'" />
	<input type="button" value="^_^"
		onclick="javascript:location.href='/pay/index'" />
		
	<script>
		function showTime() {
			var date = new Date();
			var today = date.toLocaleDateString() + "\t"
					+ date.toLocaleTimeString();
			document.getElementById("now").innerHTML = today.toString();
			window.setTimeout("showTime()", 1000);
		}
		showTime();
	</script>
<head>
</body>
</html>