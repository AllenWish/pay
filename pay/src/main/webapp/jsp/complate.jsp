<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>对比</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="${pageContext.request.contextPath}/static/jQuery/jquery.min.js"></script>
	<link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/Highcharts-5.0.11/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/static/Highcharts-5.0.11/modules/exporting.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>
<body>
	<div id="container" style="min-width: 400px;max-height: 400px;height: 400px">
	</div>
<script type="text/javascript">
    var options = {
        chart: {
            type: 'column'                          //指定图表的类型，默认是折线图（line）
        },
        title: {
            text: '记录'                 // 标题
        },
        exporting: { enabled:false },//去掉导入导出
        xAxis: {
            categories: []   // x 轴分类
        },
        credits: {
            enabled: false     //不显示LOGO
        },
        yAxis: {
            title: {
                text: '金额'                // y 轴标题
            }
        },
        series: []
    };

    function loadhc(){
        Highcharts.chart('container', options);
    }
    $(function(){
        $.post("/complate/getAll","",function (res) {
            if(res.flag){

                options.series = res.data;
                options.xAxis.categories = res.xAxis;

//                var data = res.data;
//                var sers = [];
//                for(var i=0;i<data.length;i++){
//                    var s = false;
//                    $.each(options.xAxis.categories,function (index,itm) {
//                        if(itm==data[i].createTime){
//                            s=true;
//                            var s = {name:data[i].parentName,data:data[i].totAmount}
//                            sers.push(s);
//                            return false;
//                        }
//                    });
//                    if(s){
//                        continue
//                    }else{
//                        console.info("data:"+data[i].createTime)
//                        options.xAxis.categories= data[i].createTime;
//                        var s = {name:data[i].parentName,data:data[i].totAmount}
//                        sers.push(s);
//                    }
//
//                    //options.series[i].data=data[i].totAmount;
//                    //options.series[i].name=data[i].parentName;
//                }
//                options.series = sers;
                loadhc();
            }else{
                alert(res.msg)
            }

        },"json");
    });
</script>
</body>
</html>