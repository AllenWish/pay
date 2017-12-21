<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理类别</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
    <script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
    <%--<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.js"></script>
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.css">--%>
    <link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
        function back() {
            window.history.back();
        }

	</script>
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
<div class="container content container-fluid ">
    <form class="form-inline" id="typeform">
        <div class="form-group">
            <label for="classType">消费类别：</label>
            <input type="text" class="form-control" id="classType" name="classType" placeholder="消费类别">
        </div>
        <div class="form-group">
            <label for="dtype">消费类型：</label>
            <input type="email" class="form-control" id="dtype" name="dtype" placeholder="消费类型">
        </div>
        <button type="button" class="btn btn-warning" onclick="getData()">查询</button>
        <button type="button" class="btn btn-primary" onclick="resetForm()">重置</button>
        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">新增</button>
    </form>

    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th class="col-xs-1">类别级别</th>
            <th class="col-xs-2">消费类别</th>
            <th class="col-xs-1">类型级别</th>
            <th class="col-xs-2">消费类型</th>
        </tr>
        </thead>
        <tbody id="classBody">
        <%--<c:if test="${not empty list && fn:length(list) > 0}">

            <c:forEach var="list" items="${list}" varStatus="status">
                <tr>
                    <input type="text" value=${list.id} hidden="hidden">
                    <input type="text" value=${list.pid} hidden="hidden">
                    <td>${list.classType}</td>
                    <td>${list.type}</td>
                </tr>
            </c:forEach>
        </c:if>--%>
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
                    新增类别
                </h4>
            </div>
            <div class="modal-body form-inline row form-group">
                <label for="parentTypeId" class="col-xs-2 control-label">父类:</label>
                <div class="col-xs-3">
                    <select id="parentTypeId" name="pId" class="form-control selectpicker show-tick"  data-live-search="true">
                        <option value=0>无父级</option>
                    </select>
                </div>

                <input type="text" id="id" hidden="hidden" name="id">
                <label for="className" class="col-xs-2 control-label">类别：</label>
                <input type="text" class="col-xs-3 form-control" id="className" name="className">
                <div id="alertsss" class="col-xs-10 col-xs-offset-1 alert alert-warning alert-dismissible" role="alert">
                    <button class="close" type="button" data-dismiss="alert">&times;</button>
                    <strong>Warning!</strong> className could not be null.
                </div>
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
        if(recipient==''||recipient==undefined||recipient=='undefined'){
            modal.find('.modal-title').text('新增')
            modal.find('.modal-body input').eq(1).val('');
            modal.find('.modal-body input').eq(0).val('');
//            modal.find('.modal-body input').eq(2).val('0');
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/man/getPaClass",
                dataType:'json',
                success:function(res) {
                    if(res.flag){
                        var seBody = $('#parentTypeId').empty(),$op = $("<option></option>")
                        $op.clone().text('无父级').val(0).appendTo(seBody);
                        $.each(res.data,function(index,item){
                            $op.clone().text(item.className).val(item.id).appendTo(seBody);
                        });
                    }

                }
            })

        }else {
            modal.find('.modal-title').text('编辑')

        }
    })

    function submit(){
        var className = $("#className").val();
        if(className==''){
            $('#alertsss').show();
            $('#username').onfocus();
            return;
        }
        var pid = $('#parentTypeId').val()
        var data={
            className:className,
            parentId:pid
        }
        if(pid==null||pid==undefined||pid=='0'||pid==0){
            data = {
                className:className
            }
        }

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/man/addClass",
            data:data,
            success:function(data) {
                if(data.flag){
                    $("#myModal").modal("toggle");
                    getData();
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

	function getData(){
		$.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/man/getData",
            data:$('#typeform').serialize(),
            success:function(data) {
                var flag = data.success;
                if(flag){
                    $("#classBody").empty()
                    $.each(data.data,function(index,item){
                    var $tr = $("<tr></tr>"),$td=$("<td></td>"),$inp=$("<input hidden=\"hidden\">");
                        $tr.append($inp.clone().text(item.id));
                        $tr.append($inp.clone().text(item.pId));
                        $tr.append($td.clone().text(item.classLevel));
                        $tr.append($td.clone().text(item.className));
                        $tr.append($td.clone().text(item.parLevel));
                        $tr.append($td.clone().text(item.parName));
                        $tr.appendTo($("#classBody"));
                    });
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

	function resetForm() {
        $(':input','#typeform')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
        getData()
    }

    $(document).ready(
        getData()
    );
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