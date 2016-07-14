<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<html>
	<meta charset="UTF-8">
	<title>首页</title>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/static/css/index.css">
	<style>
		.show1 {
			position: relative;
			top: 300px;
			left: 40px;
		}
		
		.show2 {
			position: relative;
			top: 220px;
			left: 240px;
		}
		
		.show3 {
			position: relative;
			top: 140px;
			left: 440px;
		}
		
		.show4 {
			position: relative;
			top: 60px;
			left: 640px;
		}
	</style>
</head>
<body>
	<div id="now" class="time"></div>
	<div class="show">
		<div class="showqu show1">
			<a href="${pageContext.request.contextPath}/showOutpay"><img
				alt="查询记录" src="static/img/button.jpg" width="40px" height="40px" /></a>
		</div>
		<div class="showqu show2">
			<a href="${pageContext.request.contextPath}/complate"><img
				alt="对比" src="static/img/button.jpg" width="40px" height="40px" /></a>
		</div>
		<div class="showqu show3">
			<a href="${pageContext.request.contextPath}/manage"><img alt="管理"
				src="static/img/button.jpg" width="40px" height="40px" /></a>
		</div>
		<div class="showqu show4">
			<a href="${pageContext.request.contextPath}/about"><img
				alt="about" src="static/img/button.jpg" width="40px" height="40px" /></a>
		</div>

	</div>

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