<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>欢迎页</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" > 
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
<style>
.show{
	width: 960*0.5px; height: 539*0.5px; 
	background-image: url(static/img/bgsea.jpg);
}

</style>
</head>
<body>
	<div id="now" class="time"></div>
	<div class="show">
		<a href="${pageContext.request.contextPath}/mypage" >
			<img class="show" src="static/img/bgsea.jpg" />
		</a>
	</div>
	<script>
		function showTime() {
			var date = new Date();
			var today = date.toLocaleDateString() + "\t" + date.toLocaleTimeString();
			document.getElementById("now").innerHTML = today.toString();
			window.setTimeout("showTime()", 1000);
		}
		showTime();
	</script>
<head>
</body>
</html>