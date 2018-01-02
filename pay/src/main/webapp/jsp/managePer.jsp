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
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>
<body>
<div class="container content">

    <form method="post" role="form" name="mf" id="perForm" action="/man/allPer">
        <div class="form-group row">

            <div class="col-md-1 ">
                <label class="control-label" for="name">姓名：</label>
            </div>

            <div class="col-md-2">
                <input type="text" name="username" class="form-control" id="name" placeholder="姓名……">
            </div>
            <div class="col-md-3 col-md-offset-1">
                <button type="button" class="btn btn-warning" onclick="getData('per')">查询</button>
                <button type="button" class="btn btn-primary" onclick="resetForm('per')">重置</button>
                <button type="button" class="btn btn-danger" onclick="doadd()">新增</button>
            </div>
        </div>
    </form>
    <hr>


<table class="table table-striped table-bordered table-hover" id="perData">
	<thead>
	<tr>
		<th class="col-xs-6" name="username">人员姓名</th>
		<th class="col-xs-6" name="opt">操作</th>

	</tr>
	</thead>
	<tbody>

	</tbody>
</table>
</div>
<script type="text/javascript">
    $(document).ready(
        getData('per')
    );
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

    function doadd(){

        window.location.href="/man/goperadd";
    }

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
                    getData('per')
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
    function deleteper(id){
        console.info(id)
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/man/deletePer",
            data:{id:id},
            success:function(data) {
                var flag = data.success;
                if(flag=='success'){
                    getData('per')
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


</script>

</body>
</html>