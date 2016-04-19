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
//   		$('#mypanel2').panel({
//   			title:'我的面板2',
//   			width:600,
//   			height:300,
//   			collapsible:true,
//   			content:'我是面板内容',
//   			iconCls:'icon-sum'
//   		});
//   		$('#mywin').window({
//   			content:'我的窗口内容',
  			
//   			onOpen : function(){
//   			 alert('窗口打开了');
//   			}
//   		});
//  			$('#btn').click(function(){
//  				$('#mywin').window({
//  					closed:false
//  				});
//  			}) ;
			$('#dialog').dialog({
				title:'我是对话框',
				iconCls:'icon-ok',
				toolbar:[
						{text:'新增',
						 iconCls:'icon-add',
						 handler: function () {
								alert('添加数据');
							}
						},
						{text:'修改'}
				],
				buttons:[
					{
						text:'确定',
						iconCls:'icon-ok',
						handler: function(){
							alert('button确定');
						}
					},
					{
						text:'取消',
						iconCls:'icon-cancle'
					}
				]
				
							
			});
  		
  	});
  	
  </script>
  </head>
  
  <body>
    <!-- 使用组件方式 1.html ,2,js -->
<!--     <div id="mypanel" style="width:300px;height: 300px" -->
<!--     class="easyui-panel" title="我的panel" iconCls="icon-add"  -->
<!--     minimizable=true maximizable=true collapsible=true  -->
<!--     closable=true -->
<!--     > -->
<!--     	我是pane的内容 -->
<!--     </div> -->
<!-- 		<div id="mypanel2" ></div> -->
<!-- 		<div id="mywin" class="easyui-window" closed=true modal=true title="我的窗口1" resizable=false style="width:200px;height: 300px" > -->
		
<!-- 		</div> -->
<!-- 		<input type="button" value="点击" onclick="alert('hello');"> -->
		
<!-- 		<a  id="btn" class="easyui-linkbutton">点击我</a> -->


		<div id="dialog" class="easyui-dialog" style="width: 300px;height: 300px">
			
		</div>
  </body>
</html>
