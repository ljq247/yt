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
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/easyui.css">
  	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css">
  	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	
  
  <script type="text/javascript">
  	$(function(){
  		//alert("111");
  		//$.messager.alert('警告','警告消息');  //不是一个alert 不会阻止窗口
  		//$.messager.alert('警告','警告消息','error');  //不是一个alert 不会阻止窗口
  		//alert("222");
  		/*
  		$.messager.confirm('标题内容','确认吗?',function(r){
  			if(r){
  				alert('确认删除');
  			}
  		});
  		*/
  		/*
  		$.messager.prompt('提示信息','请输入内容:',function(val){
  			alert(val);
  		});
  		*/
  		/*
  		$.messager.progress({
  			title:'我是进度条',
  			msg:'文本内容:很快加载完成',
  			text:'正在加载',
  			interval:1000,
  			
  		});
  		*/
  		/*
  		$.messager.show({
  			title:'提示',
  			msg:'警告!',	
  		});
  		*/
  		
  	});
  </script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
