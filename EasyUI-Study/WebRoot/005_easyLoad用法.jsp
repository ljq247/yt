<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<!-- 	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/jquery.easyui.min.js"> -->
<!--   	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css"> -->
<!--   	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script> -->
<!-- 注释掉上面三个文件  -->
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/easyloader.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	
  
  <script type="text/javascript">
  	$(function(){
  	//下面这段代码是在jquery.easyui.min.js,jquery.easyui.min.js ,icon.css
  	//这上面三个文件加载的时候使用,才不会报错
//   		$('#mydiv').window({
//   			title:'我的窗口'	,
//   			width:400,
//   			height:300
//   		});
  	//动态加载window窗口
//   		easyloader.load('window',function(){
//   			  		$('#mydiv').window({
//   			title:'我的窗口'	,
//   			width:400,
//   			height:300
//   		});
//   		});
  		//动态加载2
//   		easyloader.load(['window','messager'],
//   					function(){
//   			  			$('#mydiv').window({
//   						title:'我的窗口'	,
//   						width:400,
//   						height:300
//   					});
//   					$.messager.alert('提示信息','我是内容','error');
//   		});  	
	//html编写	
  	});
  </script>
  </head>
  
  <body>
		<div id="mydiv" ></div>  
		<!-- 动态加载,不推荐使用! --> 
		<div id="mydiv2" class="easyui-window" title="窗口2" style="width: 300px;height: 300px"></div>

  </body>
</html>
