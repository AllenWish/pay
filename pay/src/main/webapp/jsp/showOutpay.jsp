<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<title>消费记录</title>
<style type="text/css">
</style>
<script language="javascript">
	function back() {
		window.history.back();
	}
	function submitpass() {
		var pass = false;
		var ty = document.mf.type.value;
		var numty = 0;
		if(ty==""){
			numty = 0;
		}else{
			numty = parseInt(ty);
		}
		document.mf.type.value=numty;
		/* document.mf.type.value == "" && document.mf.classId.value == "" */
		if (false) {
			alert("没有输入查询条件");
			pass = false;
		} else {
			pass = true;
		}
		return pass;
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
	<form action="queryjl" method="post" role="form" name="mf" onsubmit="return submitpass()">
		<div class="form-group row">
			<div class="col-xs-1">
				<label class="control-label" for="type">消费类型</label>
			</div>
			<div class="col-xs-2">
				<input type="text" name="type" class="form-control" id="type" placeholder="消费类型">
			</div>
			<div class="col-xs-1">
				<label class="control-label" for="createUser">记录创建者</label>
			</div>

			<div class="col-xs-2">
				<input type="text" name="createUser" class="form-control" id="createUser" placeholder="记录创建者">
			</div>
			
			<div class="col-xs-1 ">
				<label class="control-label" for="createTime">记录时间</label>
			</div>

			<div class="col-xs-2">
				<input type="text" name="createTime" class="form-control" id="createTime" placeholder="输入要搜索的消费类型">
			</div>
			<div class="col-xs-2 col-md-offset-1">
				<button type="submit" class="btn btn-default">查询</button>
			</div>
		</div>
	</form>
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="col-xs-1">消费类别</th>
				<th class="col-xs-2">消费类型</th>
				<th class="col-xs-2">消费金额</th>
				<th class="col-xs-2">记录人</th>
				<th class="col-xs-2">记录时间</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty list && fn:length(list) > 0}">
			
				<c:forEach var="list" items="${list}" varStatus="status">
					<tr>
						<td>${list.classType}</td>
						<td>${list.type}</td>
						<td>${list.money}</td>
						<td>${list.createUser}</td>
						<td>${list.createTime}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

</body>
</html>