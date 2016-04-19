<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>


<script type="text/javascript">
	//success_jsonpCallback(1) ;

	$(function() {
     console.log('12121');
		$.ajax({
			url : "http://www.google.com/", //不同域名，而且google 没有允许第三方提交所以会出错
			cache : false,
			//data: params,
			dataType : 'json',
			success : function(data) {
				console.log(data);
			},
			error : function(e) {
				alert(e.statusText);
			}
		});
		// 		$.ajax({
		// 			url : 'http://www.fengyunlive.com/p/livejson/art',
		// 			dataType : "jsonp",
		// 			data : "s=40&n=40",
		// 			jsonp : "jsoncallback",
		// 			jsonpCallback : "success_jsonpCallback",
		// 			success : function(data) {
		// 				 alert('java');
		// 			}
		// 		});

		// 				$.getJSON('http://www.fengyunlive.com/p/livejson/art?s=40&n=40&jsoncallback=?&_=?', function(data){
		// 					alert('java');
		// 				});

		// 		$.ajax({
		// 			dataType : 'jsonp',
		//			url : 'http://www.a.com/user?id=123',
		// 			url : 'http://www.fengyunlive.com/p/livejson/art?s=40&n=40',
		// 			success : function(data) {
		// 				alert(data);
		//				处理data数据      
		// 			}
		// 		});

		$('#dg').datagrid({
			//url : 'json/test1.json',
			columns : [ [ {
				field : '_id',
				title : 'id',
				width : 100
			}, {
				field : 'cname',
				title : '名称',
				width : 100
			}, {
				field : 'imageUrl',
				title : 'imageUrl',
				width : 800,
				align : 'right'
			} ] ]
		});

	});
	/////


//     var flightHandler = function(data){
//         alert('你查询的航班结果是：票价 ' + data.price + ' 元，' + '余票 ' + data.tickets + ' 张。');
//     };
//     var url = "http://117.162.63.97:8080/EasyUI-Study/json/flightHandler.json";
//     var script = document.createElement('script');
//     script.setAttribute('src', url);
//     document.getElementsByTagName('head')[0].appendChild(script);


		$.ajax({
			type : "get", //jquey是不支持post方式跨域的 
			async : false,
			url : "http://www.fengyunlive.com/p/livejson/art?s=40&n=40", //跨域请求的URL 
			dataType : "jsonp",
			//传递给请求处理程序，用以获得jsonp回调函数名的参数名(默认为:callback) 
			jsonp : "callback",
			//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名 
			jsonpCallback : "success_jsonpCallback",
			//成功获取跨域服务器上的json数据后,会动态执行这个callback函数 
			success : function(json) {
				alert(json);
			},
             error: function(json){
                 console.log('error_风云直播回调函数失败!');
             }
		});

	
</script>

</head>
<body>

	<!--     <table class="easyui-datagrid" style="width:400px;height:250px"    -->
	<!--         url="json/test1.json" fitColumns=true singleSelect=true>    -->
	<!--     <thead>    -->
	<!--         <tr>    -->
	<!--             <th data-options="field:'_id',width:100">id</th>    -->
	<!--             <th data-options="field:'cname',width:100">名称</th>    -->
	<!--             <th data-options="field:'imageUrl',width:500,align:'right'">地址</th>    -->
	<!--         </tr>    -->
	<!--     </thead>    -->
	<!-- </table>  -->
	<table id="dg"></table>

</body>
</html>
