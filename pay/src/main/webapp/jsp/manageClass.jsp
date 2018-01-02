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
	<script src="${pageContext.request.contextPath}/static/js/common.js"></script>
	<script type="text/javascript">
        function back() {
            window.history.back();
        }

	</script>
</head>
<body>
<div class="content container-fluid ">
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
    <hr>
    <table id="classData" class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th class="col-xs-1 hide" name="id">id</th>
            <th class="col-xs-1" name="classLevel">类别级别</th>
            <th class="col-xs-2" name="className">消费类别</th>
            <th class="col-xs-1" name="parLevel">类型级别</th>
            <th class="col-xs-2" name="parName">消费类型</th>
            <th class="col-xs-3" name="opt">操作</th>
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
            getClass('prId','getPaClass')

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

                    var $th = $("table tr th");
                    $.each(data.data,function(index,item){
                    var $tr = $("<tr></tr>"),$hd = $("<td class='hide'></td>"),$td=$("<td></td>"),$inp=$("<input hidden=\"hidden\">")
                        ,$optDiv=$("<div class=\"btn-group btn-group-xs\" role=\"group\" ></div>");

                        $.each($th,function(index,itm){
                            var name = $(itm).attr('name');
                            if(name!='opt') {
                                if($(itm).hasClass('hide')||$(itm).hasClass('.hide')){
                                    $tr.append($hd.clone().text(item[name]));
                                }else{
                                    $tr.append($td.clone().text(item[name]));
                                }
                            }else{
                                $tr.append($td.clone().html($optDiv.clone().html("<button type=\"button\" class=\"btn btn-danger\" onclick=\"deleteType("+item.id+")\">删除</button>"
                                )));
//"<button type='button' class='btn btn-warning' data-whatever='"+item.id+"' data-toggle='modal' data-target='#myModal'  >编辑</button>"
                            }
                        });

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

    function deleteType(id){
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/man/deleteClass",
            data:{id:id},
            success:function(data) {
                if(data.flag){
                    getData()
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

    $(document).ready(
        getData()
    );

</script>
</body>
</html>