<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" > 
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
<link
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common.js"></script>
<title>消费记录</title>
<style type="text/css">
</style>
<script language="javascript">
	function back() {
		window.history.back();
	}
	
	
</script>
</head>
<body>
<div class="container">
	<form method="post" role="form" name="mf" id="payForm" action="${pageContext.request.contextPath}/pay/getData">
		<div class="form-group row">
			<div class="col-xs-1">
				<label class="control-label" for="className">类型</label>
			</div>
			<div class="col-xs-2">
				<input type="text" class="form-control" id="className" name="className" placeholder="消费类型">
			</div>
			<div class="col-xs-1">
				<label class="control-label" for="createUser">创建者</label>
			</div>

			<div class="col-xs-2">
				<input type="text" name="createUser" class="form-control" id="createUser" placeholder="记录创建者">
			</div>
			
			<div class="col-xs-1 ">
				<label class="control-label" for="createTime">时间</label>
			</div>

			<div class="col-xs-2">
				<input type="text" name="createTime" class="form-control" id="createTime" placeholder="日期……">
			</div>
			<div class="col-xs-3">
				<button type="button" class="btn btn-warning" onclick="getData('pay')">查询</button>
				<button type="button" class="btn btn-primary" onclick="resetForm('pay')">重置</button>
				<button type="button" class="btn btn-danger" onclick="doadd()">新增</button>
			</div>
		</div>
	</form>
	<hr>
	<table id="payData" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="col-xs-1 hide" name="id">id</th>
				<th class="col-xs-1" name="parName">消费类别</th>
				<th class="col-xs-2" name="className">消费类型</th>
				<th class="col-xs-2" name="j_amount">消费金额</th>
				<th class="col-xs-2" name="username">记录人</th>
				<th class="col-xs-2" name="create_time">记录时间</th>
				<th class="col-xs-2" name="opt">操作</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
</div>
</body>
<script type="text/javascript">
    $(document).ready(
        getData('pay')
    );
    function doadd(){

        window.location.href="${pageContext.request.contextPath}/pay/gosave";
    }
</script>
</html>