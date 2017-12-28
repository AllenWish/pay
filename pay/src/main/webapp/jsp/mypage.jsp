<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>首页</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
	<link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
        .body-container{
            margin-top: 50px;
            margin-bottom: 50px;
        }
        .sidebar{
            background-color: #f5f5f5;
            padding-top: 10px;
        }

	</style>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div class="navbar navbar-fixed-top bs-docs-nav  header navbar-inverse" id="top" role="banner">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

			</div>
			<nav id="bs-navbar" class="collapse navbar-collapse ">
				<ul class="nav navbar-nav">
					<a class="redirect" href="${pageContext.request.contextPath}/mypage" class="navbar-brand" id="allenwish">AllenWish</a>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<span id="timebox"></span>
				</ul>
			</nav>
		</div>
	</div>

    <div class="container-fluid body-container" >
        <div class="row">
            <div class="col-md-2 sidebar" >
                <ul class="nav nav-list">
                    <li><a href="/showOutpay" target="rightFrame">消费记录</a></li>
                    <li class="nav-divider"></li>
                    <li><a href="/complate" target="rightFrame">对比</a></li>
                    <li class="nav-divider"></li>
                    <li><a href="/manageClass" target="rightFrame">管理类别</a></li>
                    <li class="nav-divider"></li>
                    <li><a href="/managePer" target="rightFrame">管理人员</a></li>
                </ul>
            </div>
            <div class="col-md-10" style="margin-top: 30px;">
                <iframe id="rightFrame" name="rightFrame" src="/about" style="overflow:visible;"
                        scrolling="yes" frameborder="no" width="100%" ></iframe>
            </div>
        </div>
	</div>
    <div class="navbar navbar-fixed-bottom navbar-inverse row" id="bottom" role="banner">
        <div class="col-md-6 col-md-offset-3"  style="text-align: center;color:#ffffff;margin-top: 15px">
            &copy; AllenWish
        </div>
    </div>
	<script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		window.onload = function(){

			var start = {
				//获取内容div宽度
				setRedirectsWidth: function(){
					var ele = document.getElementsByClassName('content')[0];
					var redirect = document.getElementsByClassName('redirect')
					if(ele){
						redirect.clientWidth = ele.clientWidth;
						
					}
				
				},
				setHeight:function(){
				    var height = $(document).height();
				    var navHeight = $('#bottom').height()
                    var contentBodyHeight = height-2*navHeight-15;
                    $('#rightFrame').height(contentBodyHeight-30);
                    $('.sidebar').height(contentBodyHeight);
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
				var timebox = document.getElementById('timebox');
                start.setHeight();
				//设置顶部时间显示
				setInterval(function(){
					timebox.innerHTML = start.getCurrentTime();  
				}, 1000);

			})();
		};

	</script>

</body>
</html>