<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理人员</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
    <link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-static-top bs-docs-nav header" id="top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="redirect" href="${pageContext.request.contextPath}/about" class="navbar-brand">AllenWish</a>
		</div>
		<nav id="bs-navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a href="javascript:" id="loginBtn">登 录</a></li> -->
				<span id="timebox"></span>
			</ul>
		</nav>
	</div>
</div>
<%--
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
</script>--%>
<div class="container content">
        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">新增</button>
<table class="table table-striped table-bordered table-hover">
	<thead>
	<tr>
		<th class="col-xs-6">人员姓名</th>
		<th class="col-xs-6">操作</th>

	</tr>
	</thead>
	<tbody>
	<c:if test="${not empty list && fn:length(list) > 0}">

		<c:forEach var="list" items="${list}" varStatus="status">
			<tr>
				<td>${list.username}</td>
				<td>
                    <div class="btn-group btn-group-xs" role="group" >
                        <button type="button" class="btn btn-warning" data-whatever="${list.id}"
                                data-toggle="modal" data-target="#myModal"  >编辑</button>
                        <button type="button" class="btn btn-danger"
                                onclick="deleteUser(${list.id})">删除</button>
                    </div>
                </td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    新增人员
                </h4>
            </div>
            <div class="modal-body">
                <input type="text" id="id" hidden="hidden" name="id">
                人员姓名：<input type="text" id="username" name="username">
                <div id="alertsss" class="alert alert-warning alert-dismissible" role="alert">
                    <strong>Warning!</strong> username could not be null.
                </div>
                <input type="text" id="flag" name="flag" hidden="hidden">
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-danger" onclick="submit()">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script type="text/javascript">

    $('#myModal').on('show.bs.modal', function (event) {
        $('#alertsss').hide();
        var button = $(event.relatedTarget) // 触发事件的按钮
        var recipient = button.data('whatever') // 解析出whatever内容
        var modal = $(this)  //获得模态框本身
        console.info(recipient)
        if(recipient==''||recipient==undefined||recipient=='undefined'){
            modal.find('.modal-title').text('新增')
            modal.find('.modal-body input').eq(1).val('');
            modal.find('.modal-body input').eq(0).val('');
            modal.find('.modal-body input').eq(2).val('0');

        }else{
            modal.find('.modal-title').text('编辑')
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/man/getUser",
                data:{id:recipient},
                async: false,
                success:function(data) {
                    modal.find('.modal-body input').eq(1).val(data.username);
                    modal.find('.modal-body input').eq(0).val(data.id);
                    modal.find('.modal-body input').eq(2).val(data.flag);
                },
                dataType :"json",
                error:function(e){
                    console.info(e)
                }
            });
        }
    })

    function submit(){
        var username = $('#username').val();
        var id = $('#id').val();
        var flag = $('#flag').val();
        if(username==''){
            $('#alertsss').show();
            $('#username').onfocus();
            return;
        }
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/man/addPer",
            data:{
                username:username,
                id:id,
                flag:flag
            },
            success:function(data) {
                var flag = data.success;
                if(flag=='success'){
                    window.location.reload();
                }else{
                    alert(data.msg);
                }
            },
            dataType :"json",
            error:function(e){
                console.info(e)
            }
        });
    }
    function deleteUser(id){
        console.info(id)
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/man/deletePer",
            data:{id:id},
            success:function(data) {
                var flag = data.success;
                if(flag=='success'){
                    window.location.href='${pageContext.request.contextPath}/man/managePer';
                }else{
                    alert(data.msg);
                }
            },
            dataType :"json",
            error:function(e){
                console.info(e)
            }
        });
    }

	window.onload=function () {
        var start = {
            //获取内容div宽度
            setRedirectsWidth: function(){
                var ele = document.getElementsByClassName('content')[0];
                var redirect = document.getElementsByClassName('redirect')
                if(ele){
                    redirect.clientWidth = ele.clientWidth;
                }

            },
            //获取当前时间
            getCurrentTime: function(){
                var date = new Date();
                var currentTime = date.getFullYear() +
                    '-' + getDouble((date.getMonth() + 1)) +
                    '-'+ getDouble(date.getDate());
                currentTime = currentTime
                    + ' '+ getDouble(date.getHours()) + ': ' + getDouble(date.getMinutes()) +
                    ': ' + getDouble(date.getSeconds());
                return currentTime;
            },
        };

        //当数字小于10时，格式化为01、02..
        function getDouble(num){
            if(parseInt(num) < 10){
                return '0' + num;
            }else{
                return num;
            }
        };

        /*
         ** 立即执行函数
         */
        (function(){
            //var items = document.getElementsByClassName('item');
            var timebox = document.getElementById('timebox');

            //设置顶部时间显示
            setInterval(function(){
                timebox.innerHTML = start.getCurrentTime();
            }, 1000);

            /*//设置背景图片轮流切换效果
            setInterval(function(){
                start.slide(items);
            }, 5000);*/
        })();
    };
</script>

</body>
</html>