<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>关于我们</title>
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
  </script>
</head>
<body>

<div class="container">
  <div class="jumbotron" onclick="javascript:history.back()" style="cursor:pointer">
    <h1>我们</h1>
    <p>这是一个基于SSM(Spring+SpringMVC+Mybatis)框架的系统，用来记录个人的消费记录！</p>
  </div>
  <div class="row">
    <div class="col-sm-4">
      <h3>联系我</h3>
      <p>AllenWish：<a href="http://wpa.qq.com/msgrd?v=3&amp;uin=1697501868&amp;site=qq&amp;menu=yes" style="cursor:pointer">在线交流！</a></p>
      <p>TracyGreenYou：<a href="mailto:cuigenyou@163.com?subject=%E5%85%B3%E4%BA%8Epay%E7%B3%BB%E7%BB%9F%E4%BA%A4%E6%B5%81" style="cursor:pointer">邮件交流！</a></p>
    </div>
    <div class="col-sm-4">
      <h3>在线时间</h3>
      <p>周一至周五：9:00-11:30,13:30-17:00！</p>
      <p>周六、周日：全天24小时任性在线（不定时在线）！</p>
    </div>
    <div class="col-sm-4">
      <h3>其他联系方式</h3>        
      <p>电话：私人保密！</p>
      <p>邮箱：cuigenyou@163.com ！</p>
    </div>
  </div>
</div>

</body>
</html>
