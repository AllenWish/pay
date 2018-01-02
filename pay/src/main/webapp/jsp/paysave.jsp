<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>添加</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" > 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap-datetimepicker.min.css">
  <script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
    <style type="text/css">
        .alert{padding:5px;margin-bottom:0px;}
    </style>
  <script type="text/javascript">

  </script>
</head>
<body>

<div class="container">
  <form method="post" role="form" name="mf" id="payForm" action="/pay/dosave">
      <input hidden="hidden"  name="id" id="id" value="${pay.id}">
      <div class="form-group ">
          <div class="row">
              <div class="col-md-2 ">
                  <label class="control-label" for="prId">类别：</label>
              </div>
              <div class="col-md-2">
                  <select class="form-control" name="bigClassId" id="prId">
                  </select>
              </div>
              <div class="col-md-5 alert alert-danger alert-dismissible" id="praAlert">
                  <strong>error!</strong> please select parentType!!!.
              </div>
          </div>
          <div class="row">
              <div class="col-md-2 ">
                  <label class="control-label" for="claId">类型：</label>
              </div>
              <div class="col-md-2">
                  <select class="form-control" name="smClassId" id="claId">
                  </select>
              </div>
              <div class="col-md-5 alert alert-danger alert-dismissible" id="claAlert">
                  <strong>error!</strong> please select classtype!!!.
              </div>
          </div>
          <div class="row">
              <div class="col-md-2 ">
                  <label class="control-label" for="jAmount">金额：</label>
              </div>

              <div class="col-md-2">
                  <input type="text" name="jAmount" class="form-control" required id="jAmount" placeholder="金额……"
                         value="${pay.jAmount}" onblur="check()">
              </div>
              <div class="col-md-5 alert alert-danger alert-dismissible" id="amountAlert">
                  <strong>error!</strong> please enter amount!!!.
              </div>
          </div>

          <div class="row">
              <div class="col-md-2 ">
                  <label class="control-label" for="userId">消费者：</label>
              </div>
              <div class="col-md-2">
                  <select class="form-control" name="userId" id="userId">
                  </select>
              </div>
              <div class="col-md-5 alert alert-danger alert-dismissible" id="userAlert">
                  <strong>error!</strong> please select user!!!.
              </div>
          </div>
          <div class="row">
              <div class="col-md-2 ">
                  <label class="control-label" for="createTime">时间：</label>
              </div>
              <div class="col-md-2" >
                  <div class="input-append date" id="datetimepicker" data-date="" data-date-format="yyyy-MM-dd" data-link-field="createTime" data-link-format="yyyy-MM-dd">
                      <input class="form-control" size="16" type="text" name="createTime" id="createTime" >
                      <span class="add-on"><i class="icon-th"></i></span>
                  </div>
              </div>
              <div class="col-md-5 alert alert-danger alert-dismissible" id="timeAlert">
                  <strong>error!</strong> please enter time!!!.
              </div>
          </div>
          <hr>
          <div class="row">
              <div class="col-md-3 col-md-offset-2">
                  <button type="button" class="btn btn-primary" onclick="sub()">提交</button>
                  <button type="button" class="btn btn-danger" onclick="back()">返回</button>
              </div>
          </div>
      </div>
  </form>
</div>
<script type="text/javascript">
    function init(){
        //alert
        $('.alert').hide()
        getClass('prId','getPaClass')
        getUser('userId')
        $('#prId').change(function(){
            var prId = $('#prId').val();
            getClass('claId','getChClass?parId='+prId)
        })

    }
    $(document).ready(
       init()
    );

    function sub(){
        var createTime= $('#createTime').val()
        if(createTime==null||createTime.length<=8){
            $('#timeAlert').show()
            return false;
        }else{
            $('#timeAlert').hide()
        }
        var jAmount= $('#jAmount').val()
        if(jAmount==null||jAmount==''||isNaN(jAmount)||jAmount=='NaN'||jAmount<=0){
            $('#amountAlert').show();
            return false;
        }else{
            $('#amountAlert').hide()
        }
        var classId = $('#claId').val();
        if(classId<=0||classId==null||classId==''||isNaN(classId)||classId=='NaN'){
            $('#claAlert').show();
            return false;
        }else{
            $('#claAlert').hide()
        }
        var prId = $('#prId').val();
        if(prId<=0||prId==null||prId==''||isNaN(prId)||prId=='NaN'){
            $('#praAlert').show();
            return false;
        }else{
            $('#praAlert').hide()
        }
        subForm('payForm');
    }

    $('#datetimepicker').datetimepicker({
        language: 'zh-CN',
        weekStart: 0,
        todayBtn:  "linked",
        autoclose: true,
        format:'yyyy-MM-dd',
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: true
    });
</script>
</body>
</html>
