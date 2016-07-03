<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>首页</title>
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		* { font-family: 'Microsoft Yahei'; }
		body{
			background: #f8f8f8;
		}
		.header{ background: #e8e8e8; border-bottom: 1px solid #f7f7f7}
		.content{ 
			background: #fff; padding: 0;
			position: relative;
		}
		.content ul{ padding-left: 0;}
		.content .item{list-style: none;}
		.content .item img{
			height: 460px; width: 100%; border-radius: 5px;
		}
		.content .redirect-box{
			position: absolute;
			bottom: 40px;
			margin-left: 0;
			margin-right: 0;
			padding-left: 0;
			padding-right: 0;
			background: black;
			filter: alpha(opacity = 50);
			opacity: 0.6;
		}
		.content .redirect-item{
			 	height: 70px;
			 }
		.content .redirect-item .redirect{
			display: block; text-align: center; line-height: 70px;
		}

		.content .redirect-item .redirect:hover,.redirect:visited{
			text-decoration: none;
			background: #e8e8e8;
			filter: alpha(opacity = 50);
			opacity: 0.6;
		}

		#timebox{ line-height: 45px; color: #007ACC }
	</style>
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
				<a href="#" class="navbar-brand">AllenWish</a>
			</div>
			<nav id="bs-navbar" class="collapse navbar-collapse">
<!-- 				<ul class="nav navbar-nav">
					<li>
						<a href="#">主页</a>
					</li>
					<li>
						<a href="#">文章</a>
					</li>
					<li>
						<a href="#">讨论</a>
					</li>
					<li>
						<a href="#">JavaScript 插件</a>
					</li>
					<li>
						<a href="../customize/">定制网站</a>
					</li>
					<li><a href="#">个人项目</a></li>
				</ul> -->
				<ul class="nav navbar-nav navbar-right">
					<!-- <li><a href="javascript:" id="loginBtn">登 录</a></li> -->
					<span id="timebox"></span>
				</ul>
			</nav>
		</div>
	</div>

	<div class="container content">
		<ul>
			<li class="item">
				<img src="static/img/background1.jpg" alt="">
			</li>
			<li class="item" style="display: none;">
				<img src="static/img/background2.jpg" alt="">
			</li>
			<li class="item" style="display: none;">
				<img src="static/img/background3.jpg" alt="">
			</li>				
		</ul>	

		<div class="row container redirect-box">
			<div class="col-sm-3 redirect-item">
				<a class="redirect" href="${pageContext.request.contextPath}/showOutpay">查询记录</a>
			</div>
			<div class="col-sm-3 redirect-item">
				<a class="redirect" href="${pageContext.request.contextPath}/complate">对比</a>
			</div>
			<div class="col-sm-3 redirect-item">
				<a class="redirect" href="${pageContext.request.contextPath}/manage">管理</a>
			</div>
			<div class="col-sm-3 redirect-item">
				<a class="redirect" href="${pageContext.request.contextPath}/about">关于我们</a>
			</div>
		</div>
	</div>

	<script src="http://cdn.bootcss.com/jquery/1.12.1/jquery.min.js"></script>
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
				//幻灯片效果
				slide: function(eles){
					var items = eles || [];
					for(var i = 0; i<items.length; i++){
						if(items[i].style.display != 'none'){
							items[i].style.display = 'none';
							if(i == items.length - 1){
								items[0].style.display = "block";
								break;
							}else{
								items[i+1].style.display = "block";
								break;
							}
						}
					}
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
				var items = document.getElementsByClassName('item');
				var timebox = document.getElementById('timebox');			
				
				//设置顶部时间显示
				setInterval(function(){
					timebox.innerHTML = start.getCurrentTime();  
				}, 1000);

				//设置背景图片轮流切换效果
				setInterval(function(){
						start.slide(items);
			 	}, 5000);
			})();
		};

	</script>

</body>
</html>