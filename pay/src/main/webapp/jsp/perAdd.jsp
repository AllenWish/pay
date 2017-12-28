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

  	        return false;
        }
        $.post(
            $("#perForm").attr("action"),
            $("#perForm").serialize(),
            function(res){
                if(res.flag){
                    window.location.href=res.msg;
                }else{
                    alert(res.msg)
                }
            },
            "json"
        );
    }
  </script>
</head>
<body>

<div class="container">
  <form method="post" role="form" name="mf" id="perForm" action="/man/dopersave">
      <div class="form-group row">

          <div class="col-md-1 ">
              <label class="control-label" for="username">姓名：</label>
          </div>

          <div class="col-md-2">
              <input type="text" name="username" class="form-control" required id="username" placeholder="姓名……">
          </div>

          <div class="col-md-3 col-md-offset-1">
              <button type="button" class="btn btn-primary" onclick="sub()">提交</button>
              <button type="button" class="btn btn-danger" onclick="back()">返回</button>
          </div>
      </div>
  </form>
</div>

</body>
</html>
