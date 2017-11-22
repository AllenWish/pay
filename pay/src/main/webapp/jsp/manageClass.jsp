<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理类别</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
        function back() {
            window.history.back();
        }

	</script>
</head>
<body>
<div id="now" class="time"></div>
<br />
<hr>
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
<table class="table table-striped table-bordered table-hover">
	<thead>
	<tr>
		<th class="col-xs-1">消费类别</th>
		<th class="col-xs-2">消费类型</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${not empty list && fn:length(list) > 0}">

		<c:forEach var="list" items="${list}" varStatus="status">
			<tr>
				<input type="text" value=${list.id} hidden="hidden">
				<input type="text" value=${list.pid} hidden="hidden">
				<td>${list.classType}</td>
				<td>${list.type}</td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>

</body>
</html>