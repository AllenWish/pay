<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>人员新增</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" > 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">  
  <script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	function open_win(s){
  		window.open(s)
  	}
  	function sub(){
  	    var username = $("#username").val();
  	    if(username==''||username.length<=0||username.length>10){
            $("#alert").removeClass("hide")
  	        return false;
        }
        subForm('perForm')
    }
  </script>
</head>
<body>

<div class="container">
  <form method="post" role="form" name="mf" id="perForm" action="${pageContext.request.contextPath}/man/dopersave">
      <input hidden="hidden"  name="id" id="id" value="${user.id}">
      <input hidden="hidden"  name="flag" id="flag" value="0">
      <div class="form-group row">
          <div class="col-md-1 ">
              <label class="control-label" for="username">姓名：</label>
          </div>

          <div class="col-md-2">
              <input type="text" name="username" class="form-control" required id="username" placeholder="姓名……"
                     value="${user.username}" onblur="check()">
          </div>

          <div class="col-md-4">
              <div id="alert" class="alert alert-warning hide">
                  <strong>警告！</strong>请正确填写姓名
              </div>
          </div>
          <div class="col-md-3 col-md-offset-1">
              <button type="button" class="btn btn-primary" onclick="sub()">提交</button>
              <button type="button" class="btn btn-danger" onclick="back()">返回</button>
          </div>
      </div>
  </form>
</div>
<script type="application/javascript">
    function check(){
        var username = $("#username").val();
        if(username==''||username.length<=0||username.length>10){
            $("#alert").removeClass("hide")
        }else{
            $("#alert").addClass("hide")
        }
    }
</script>
</body>
</html>
